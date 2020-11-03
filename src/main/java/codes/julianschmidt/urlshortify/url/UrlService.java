package codes.julianschmidt.urlshortify.url;

import org.springframework.stereotype.Component;

import codes.julianschmidt.urlshortify.url.dto.RetrieveUrlDto;
import codes.julianschmidt.urlshortify.url.dto.ShortenUrlDto;
import codes.julianschmidt.urlshortify.url.model.Url;

@Component
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public Url shortenUrl(ShortenUrlDto original) {
        String shortUrl = "2348976dfb";
        return repository.save(new Url(original.getOriginalUrl(), shortUrl));
    }

    public Url retrieve(RetrieveUrlDto shortened) {
        return repository.findByShortUrl(shortened.getShortUrl()).orElse(null);
    }

}
