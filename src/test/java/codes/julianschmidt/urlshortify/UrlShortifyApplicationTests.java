package codes.julianschmidt.urlshortify;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UrlShortifyApplicationTests {

    @Test
    void contextLoads() {
        UrlShortifyApplication app = new UrlShortifyApplication();
        assertNotNull(app);
    }

}
