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

    private final UrlService service;

    UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/url")
    public Url shortenUrl(ShortenUrlDto original) {
        LOGGER.debug("Shortening URL '{}' ...", original.getOriginalUrl());
        return service.shortenUrl(original);
    }

    @GetMapping("/url")
    public Url retrieve(RetrieveUrlDto shortened) {
        LOGGER.debug("Retrieving URL for short URL '{}' ...", shortened.getShortUrl());
        return service.retrieve(shortened);
    }

}
