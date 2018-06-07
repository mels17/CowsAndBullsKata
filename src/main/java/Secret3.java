import java.util.Objects;

public class Secret3 {
    private int _secret;

    // For the game
    public Secret3() {
        _secret = generateSecret();
    }

    // For the user
    public Secret3(int _secret) {
        this._secret = _secret;
    }

    private int generateSecret() {
        return 1234;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secret3 secret3 = (Secret3) o;
        return _secret == secret3._secret;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_secret);
    }
}
