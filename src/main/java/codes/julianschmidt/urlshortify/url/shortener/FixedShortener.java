package codes.julianschmidt.urlshortify.url.shortener;

import codes.julianschmidt.urlshortify.url.model.Url;

public class FixedShortener implements UrlShortener {

    @Override
    public Url decorateShortenedUrl(Url original) {
        original.setShortUrl("2348976dfb");
        return original;
    }

}
