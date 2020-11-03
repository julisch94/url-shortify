package codes.julianschmidt.urlshortify.url.shortener;

import org.springframework.stereotype.Component;

import codes.julianschmidt.urlshortify.url.model.Url;

@Component
public class FixedShortener implements UrlShortener {

    @Override
    public Url decorateShortenedUrl(Url original) {
        original.setShortUrl("2348976dfb");
        return original;
    }

}
