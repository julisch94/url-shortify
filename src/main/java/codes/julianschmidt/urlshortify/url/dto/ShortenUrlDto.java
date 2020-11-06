package codes.julianschmidt.urlshortify.url.dto;

import javax.validation.constraints.NotNull;

import codes.julianschmidt.urlshortify.url.model.Url;
import codes.julianschmidt.urlshortify.url.validator.ValidUrl;

public class ShortenUrlDto {

    @NotNull(message = "URL must not be null")
    @ValidUrl
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
