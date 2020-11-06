package codes.julianschmidt.urlshortify.url.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Url {

    @Id
    @GeneratedValue
    private long id;

    private String longUrl;

    private String token;

    public Url() {
    }

    public Url(String longUrl, String token) {
        this.longUrl = longUrl;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String shortUrl) {
        this.token = shortUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Url url = (Url) o;
        return id == url.id
                && Objects.equals(longUrl, url.longUrl)
                && Objects.equals(token, url.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, longUrl, token);
    }

    @Override
    public String toString() {
        return "Url{" + "id=" + id + ", longUrl='" + longUrl + '\'' + ", token='" + token + '\'' + '}';
    }
}
