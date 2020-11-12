package codes.julianschmidt.urlshortify.url.shortener;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import codes.julianschmidt.urlshortify.url.model.Url;

class FixedShortenerTest {

    private FixedShortener uut;

    @BeforeEach
    void setUp() {
        uut = new FixedShortener();
    }

    @Test
    void decorateToken() {
        Url url = new Url();
        url.setLongUrl("fake-long-url");

        Url result = uut.decorateToken(url);

        assertThat(result.getToken()).isNotNull();
    }
}
