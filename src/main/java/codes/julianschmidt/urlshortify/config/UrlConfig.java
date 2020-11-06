package codes.julianschmidt.urlshortify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import codes.julianschmidt.urlshortify.url.UrlRepository;
import codes.julianschmidt.urlshortify.url.shortener.RandomShortener;
import codes.julianschmidt.urlshortify.url.shortener.UrlShortener;

@Configuration
public class UrlConfig {

    private final UrlRepository repository;

    public UrlConfig(UrlRepository repository) {
        this.repository = repository;
    }

    @Bean
    public UrlShortener urlShortener() {
        return new RandomShortener(repository);
    }
}
