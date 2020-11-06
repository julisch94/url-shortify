package codes.julianschmidt.urlshortify.url;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import codes.julianschmidt.urlshortify.url.model.Url;

public interface UrlRepository extends JpaRepository<Url, Long> {

    /**
     * Finds a URL object by using the token as a search criteria.
     *
     * @return a URL object with matches exactly the given token
     */
    Optional<Url> findByToken(String token);

}
