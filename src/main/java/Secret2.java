import java.util.Objects;

public class Secret2 {
    private int _secret;

    public Secret2() {
        _secret = generateSecret();
    }

    private int generateSecret() {
        return 1234;
    }

    public int get_secret() {
        return _secret;
    }
}
