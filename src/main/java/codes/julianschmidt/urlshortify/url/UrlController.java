package codes.julianschmidt.urlshortify.url;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UrlService.FailedToRetrieveUrlException.class)
    public String handleNotFound(Exception ex) {
        return ex.getMessage();
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UrlService.FailedToShortenUrlException.class)
    public String handleInternalError(Exception ex) {
        return ex.getMessage();
    }

}
