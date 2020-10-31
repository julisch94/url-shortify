package codes.julianschmidt.urlshortify.url;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import codes.julianschmidt.urlshortify.url.dto.RetrieveUrlDto;
import codes.julianschmidt.urlshortify.url.dto.ShortenUrlDto;
import codes.julianschmidt.urlshortify.url.model.Url;

@RestController
public class UrlController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlController.class);

    @PostMapping("/url")
    public Url shortenUrl(ShortenUrlDto original) {
        String originalUrl = original.getOriginalUrl();
        LOGGER.debug("Shortening URL '{}' ...", originalUrl);
        return new Url(originalUrl, originalUrl);
    }

    @GetMapping("/url")
    public Url retrieve(RetrieveUrlDto shortened) {
        String shortUrl = shortened.getShortUrl();
        LOGGER.debug("Retrieving URL for short URL '{}' ...", shortUrl);
        return new Url(shortUrl, shortUrl);
    }

}
