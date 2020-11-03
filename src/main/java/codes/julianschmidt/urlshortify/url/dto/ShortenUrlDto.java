package codes.julianschmidt.urlshortify.url.dto;

import codes.julianschmidt.urlshortify.url.model.Url;

public class ShortenUrlDto {

    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Url toUrl() {
        return new Url(originalUrl, null);
    }

}
