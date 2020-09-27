package codes.julianschmidt.urlshortify.url;

public class UrlCreationFailedException extends RuntimeException {
    public UrlCreationFailedException(String url) {
        super(String.format("Failed to create URL '%s'", url));
    }
}
