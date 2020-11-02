package codes.julianschmidt.urlshortify.url;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import codes.julianschmidt.urlshortify.url.model.Url;

public interface UrlRepository extends JpaRepository<Url, Long> {

    /**
     * Finds a URL object by using the short URL as a search criteria.
     *
     * @return a URL object with matches exactly the given short URL
     */
    Optional<Url> findByShortUrl(String shortUrl);

}
