package codes.julianschmidt.urlshortify.url.shortener;

import codes.julianschmidt.urlshortify.url.model.Url;

public interface UrlShortener {

    /**
     * Converts a given URL into a token (e.g. Hi2xNq) to be used as suffix of the shortened URL.
     *
     * @param original a given URL which might be used for the generation
     * @return the URL object with the newly generated token
     */
    Url decorateToken(Url original);

}
