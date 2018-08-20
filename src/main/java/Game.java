import java.util.stream.Collectors;

public class Game {

    private Reader _reader;
    private Writer _writer;
    private SecretFactory _secretFactory;

    public Game(Reader reader, Writer writer, SecretFactory secretFactory) {
        _reader = reader;
        _writer = writer;
        _secretFactory = secretFactory;
    }

    public void start() {
        printWelcomeMessage();
        Secret secret = getSecret();
        Result result;
        do {
            printWelcomeMessage();
            Secret guess = getGuess();
            result = compare(secret, guess);
            printResult(result);
        } while (!gameOver(result));
    }

    private void printWelcomeMessage() {
        _writer.write("Game started...");
    }

    private void printResult(Result result) {
        _writer.write("Result: " + result);
    }

    private void printGuessInputMessage() {
        _writer.write("Enter guess: ");
    }

    private boolean gameOver(Result result) {
        return result.bulls == 4;
    }

    public Result compare(Secret secret, Secret guess) {
        if (secret.secretValue.length() != guess.secretValue.length()) return new Result(0, 0);

        int bulls = calculateBulls(secret, guess);
        int cows = calculateCows(secret, guess) - bulls;

//        for (int i = 0; i < secret.secretValue.length(); i++) {
//            char guessChar = guess.secretValue.charAt(i);
//            if (guessChar == secret.secretValue.charAt(i)) {
//                bulls++;
//            } else if (secret.secretValue.contains(Character.toString(guessChar))) {
//                int count = (int) secret.secretValue.chars().filter(num -> num == guessChar).count();
//                cows += count;
//            }
//        }
        return new Result(cows, bulls);
    }

    private int calculateCows(Secret secret, Secret guess) {
        int cows = 0;
        String newSecret = secret.secretValue.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
        String newGuess = guess.secretValue.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
        for (int i = 0; i < newGuess.length(); i++) {
            if (newSecret.indexOf(newGuess.charAt(i)) >= 0) {
                cows++;
            }
        }
        return cows;
    }

    private int calculateBulls(Secret secret, Secret guess) {
        int bulls = 0;

        for (int i = 0; i < secret.secretValue.length(); i++) {
            char guessChar = guess.secretValue.charAt(i);
            if (guessChar == secret.secretValue.charAt(i)) {
                bulls++;
            }
        }
        return bulls;
    }

    private Secret getGuess() {
        printGuessInputMessage();
        return new Secret(_reader.read());
    }

    private Secret getSecret() {
        Secret secret = _secretFactory.create();
        System.out.println(secret);
        return secret;
    }
}
