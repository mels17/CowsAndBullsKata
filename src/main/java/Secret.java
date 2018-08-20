public class Secret {

    final String secretValue;

    public Secret(String s) {
        secretValue = s;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Secret) {
            return ((Secret) o).secretValue.equals(this.secretValue);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Secret{" +
                "secretValue='" + secretValue + '\'' +
                '}';
    }
}
