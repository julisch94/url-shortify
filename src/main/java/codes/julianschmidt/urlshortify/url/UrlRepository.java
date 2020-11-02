package codes.julianschmidt.urlshortify.url;

import org.springframework.data.jpa.repository.JpaRepository;

import codes.julianschmidt.urlshortify.url.model.Url;

public interface UrlRepository extends JpaRepository<Url, Long> {

}
