package codes.julianschmidt.urlshortify.url.shortener;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import codes.julianschmidt.urlshortify.url.UrlRepository;
import codes.julianschmidt.urlshortify.url.model.Url;

public class RandomShortener implements UrlShortener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomShortener.class);
    private static final int DIGITS = 6;

    private final UrlRepository repository;

    public RandomShortener(UrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public Url decorateShortenedUrl(Url original) {
        String shortUrl = getUniqueRandomString();
        LOGGER.debug("unique random string was generated: {}", shortUrl);
        original.setShortUrl(shortUrl);
        return original;
    }

    private String getUniqueRandomString() {
        while (true) {
            String candidate = generateRandomString();
            LOGGER.trace("random string candidate generated: {}", candidate);
            if (isUnique(candidate)) {
                LOGGER.trace("{} is unique", candidate);
                return candidate;
            }
        }
    }

    /**
     * Override this to use own random generators.
     *
     * @return a randomly generated string consisting of [a-zA-Z0-9]
     */
    protected String generateRandomString() {
        return RandomStringUtils.randomAlphanumeric(DIGITS);
    }

    private boolean isUnique(String candidate) {
        return repository.findByShortUrl(candidate).isEmpty();
    }

}
