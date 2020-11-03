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
                .orElse(null);
    }

    public Url retrieve(RetrieveUrlDto shortened) {
        return repository.findByShortUrl(shortened.getShortUrl()).orElse(null);
    }

}
