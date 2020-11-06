package codes.julianschmidt.urlshortify.url.dto;

import codes.julianschmidt.urlshortify.url.model.Url;

public class ShortenUrlDto {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Url toUrl() {
        return new Url(url, null);
    }

}
