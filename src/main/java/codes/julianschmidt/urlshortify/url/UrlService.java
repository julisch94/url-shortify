package codes.julianschmidt.urlshortify.url;

import java.util.Optional;

import org.springframework.stereotype.Component;

import codes.julianschmidt.urlshortify.url.dto.RetrieveUrlDto;
import codes.julianschmidt.urlshortify.url.dto.ShortenUrlDto;
import codes.julianschmidt.urlshortify.url.model.Url;
import codes.julianschmidt.urlshortify.url.shortener.UrlShortener;

@Component
public class UrlService {

    private final UrlRepository repository;
    private final UrlShortener shortener;

    public UrlService(UrlRepository repository, UrlShortener shortener) {
        this.repository = repository;
        this.shortener = shortener;
    }

    public Url shortenUrl(ShortenUrlDto original) {
        return Optional.of(original)
                .map(ShortenUrlDto::toUrl)
                .map(shortener::decorateShortenedUrl)
                .map(repository::save)
                .orElseThrow(() -> new FailedToShortenUrlException(original));
    }

    public Url retrieve(RetrieveUrlDto shortened) {
        return repository.findByShortUrl(shortened.getShortUrl())
                .orElseThrow(() -> new FailedToRetrieveUrlException(shortened));
    }

    public static class FailedToShortenUrlException extends RuntimeException {
        public FailedToShortenUrlException(ShortenUrlDto original) {
            super(String.format("Failed to shorten the URL: '%s'", original.getOriginalUrl()));
        }
    }

    public static class FailedToRetrieveUrlException extends RuntimeException {
        public FailedToRetrieveUrlException(RetrieveUrlDto shortened) {
            super(String.format("Failed to retrieve the URL: '%s'", shortened.getShortUrl()));
        }
    }
}
