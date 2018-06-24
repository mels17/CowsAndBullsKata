import java.util.List;
import java.util.Objects;

public class Secret4 {

    private List<String> secret;
    public Secret4(List<String> secret) {
        this.secret = secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secret4 secret4 = (Secret4) o;
        return Objects.equals(secret, secret4.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secret);
    }
}
