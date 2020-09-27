package codes.julianschmidt.urlshortify.url;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(String key) {
        super(String.format("Could not find url '%s'", key));
    }
}
