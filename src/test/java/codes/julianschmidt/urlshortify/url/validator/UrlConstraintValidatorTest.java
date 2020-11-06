package codes.julianschmidt.urlshortify.url.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UrlConstraintValidatorTest {

    UrlConstraintValidator validator = new UrlConstraintValidator();

    @ParameterizedTest
    @ValueSource(strings = {
            "http://hellothere.com",
            "https://www.google.com",
            "https://www.kit.edu/",
            "https://www.nexusgroup.com/de/",
            "https://www.bsi.bund.de/DE/Home/home_node.html",
            "http://this-is-my-domain.org",
            "http://this-is-my-domain.org:8000",
            "https://www.google.de/maps/place/Brandenburger+Tor/@52.5068441,13.4247317,10z/data=!4m13!1m7!3m6!1s0x47a84e373f035901:0x42120465b5e3b70!2sBerlin!3b1!8m2!3d52.5200066!4d13.404954!3m4!1s0x47a851c655f20989:0x26bbfb4e84674c63!8m2!3d52.5162731!4d13.3777428"
    })
    void isValid(String candidate) {
        assertTrue(validator.isValid(candidate, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "www.facebook.com",
            "www.kit.edu",
            ".hello/whatup",
            "source://bla.de",
            "ftp://this-is-a-file",
            "localhost",
            "http://localhost",
            "https://localhost:8080"
    })
    void isNotValid(String candidate) {
        assertFalse(validator.isValid(candidate, null));
    }
}