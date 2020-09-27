package codes.julianschmidt.urlshortify.url;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class UrlController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlController.class);

    private Map<String, String> urls;

    public UrlController() {
        urls = new HashMap<>();
    }

    @PostMapping("/url")
    public String shortenUrl(@RequestParam(value = "orig") String originalUrl) {
        LOGGER.debug("Shortening URL '{}' ...", originalUrl);
        String shortUrl = "42";
        urls.put(shortUrl, originalUrl);
        return Optional.ofNullable(urls.get(shortUrl))
                .orElseThrow(() -> new UrlCreationFailedException(originalUrl));
    }

    @GetMapping("/url/{shortUrl}")
    public String retrieveUrl(@PathVariable String shortUrl) {
        LOGGER.debug("Retrieving URL for short URL '{}' ...", shortUrl);
        return Optional.ofNullable(urls.get(shortUrl))
                .orElseThrow(() -> new UrlNotFoundException(shortUrl));
    }

}
