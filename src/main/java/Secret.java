import java.util.stream.Collectors;

public class Secret {

    final String secretValue;

    public Secret(String s) {
        secretValue = s;
    }

    public int getLengthOfSecret() {
        return secretValue.length();
    }

    public Result compare(Secret guess) {
        if (secretValue.length() != guess.secretValue.length()) return new Result(0, 0);
        int bulls = 0;
        String newSecret = "";
        String newGuess = "";
        for (int i = 0; i < secretValue.length(); i++) {
            char guessChar = guess.secretValue.charAt(i);
            if (guessChar == secretValue.charAt(i)) {
                bulls++;
            } else {
                newGuess += guessChar;
                newSecret += secretValue.charAt(i);
            }
        }
        int cows = calculateCows(newSecret, newGuess);
        return new Result(cows, bulls);
    }

    private int calculateCows(String secret, String guess) {
        int cows = 0;
        String secretWithoutBulls = secret.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
        for (int i = 0; i < secretWithoutBulls.length(); i++) {
            char comparer = secretWithoutBulls.charAt(i);
            int count = Math.toIntExact(guess.chars().filter(ch -> ch == comparer).count());
            cows += count > 1 ? 1 : count;
        }
        return cows;
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
