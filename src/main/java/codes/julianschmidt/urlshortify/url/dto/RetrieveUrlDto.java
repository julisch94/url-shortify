package codes.julianschmidt.urlshortify.url.dto;

import javax.validation.constraints.NotNull;

public class RetrieveUrlDto {

    @NotNull(message = "Token must not be null")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
