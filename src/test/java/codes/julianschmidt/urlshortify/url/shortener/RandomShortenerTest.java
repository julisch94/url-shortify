package codes.julianschmidt.urlshortify.url.shortener;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import codes.julianschmidt.urlshortify.url.UrlRepository;
import codes.julianschmidt.urlshortify.url.model.Url;

class RandomShortenerTest {

    public static final Pattern RANDOM_REGEX = Pattern.compile("[a-zA-Z0-9]{6}");

    private RandomShortener uut;

    @BeforeEach
    void setUp() {
        UrlRepository repository = Mockito.mock(UrlRepository.class);
        uut = new RandomShortener(repository);
    }

    @Test
    void decorateToken() {
        Url url = new Url();
        url.setLongUrl("fake-long-url");

        Url result = uut.decorateToken(url);

        assertThat(result.getToken()).matches(RANDOM_REGEX);
    }

    @RepeatedTest(value = 10)
    void generateRandomString() {
        String random = uut.generateRandomString();
        assertThat(random).matches(RANDOM_REGEX);
    }

}
