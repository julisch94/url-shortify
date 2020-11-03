package codes.julianschmidt.urlshortify.url.shortener;

import codes.julianschmidt.urlshortify.url.model.Url;

public interface UrlShortener {

    Url decorateShortenedUrl(Url original);

}
