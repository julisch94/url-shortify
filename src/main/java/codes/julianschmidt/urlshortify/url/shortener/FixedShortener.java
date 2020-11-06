package codes.julianschmidt.urlshortify.url.shortener;

import codes.julianschmidt.urlshortify.url.model.Url;

public class FixedShortener implements UrlShortener {

    @Override
    public Url decorateToken(Url original) {
        original.setToken("2348976dfb");
        return original;
    }

}
