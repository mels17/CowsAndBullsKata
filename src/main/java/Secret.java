import java.util.Objects;

public class Secret {

    private String secretValue;

    public Secret(String s) {
        secretValue = s;
    }

    public String getSecretValue() {
        return secretValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Secret) {
            return ((Secret) o).getSecretValue().equals(this.secretValue);
        }
        return false;
    }
}
