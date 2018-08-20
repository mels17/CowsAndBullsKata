import com.sun.deploy.util.StringUtils;

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
//        int cows = calculateCows(secret, guess) - bulls;
        return calculateBulls(secret, guess);
    }

    private int calculateCows(Secret secret, Secret guess) {
        int cows = 0;
        String newSecret = secret.secretValue.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
//        String newGuess = guess.secretValue.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());

        for (int i = 0; i < newSecret.length(); i++) {
            char comparer = newSecret.charAt(i);
            int count = Math.toIntExact(guess.secretValue.chars().filter(ch -> ch == comparer).count());
            System.out.println("Iteration " + i + " " + count );
            cows += count > 1 ? 1 : count;
//            if (secret.secretValue.indexOf(newGuess.charAt(i)) >= 0) {
//                cows++;
//            }
        }
        return cows;
    }

    private Result calculateBulls(Secret secret, Secret guess) {
        int bulls = 0;
        String newSecret = "";
        String newGuess = "";
        for (int i = 0; i < secret.secretValue.length(); i++) {
            char guessChar = guess.secretValue.charAt(i);
            if (guessChar == secret.secretValue.charAt(i)) {
                bulls++;
            } else {
                newGuess += guessChar;
                newSecret += secret.secretValue.charAt(i);
            }
        }

        int cows = calculateCows(new Secret(newSecret), new Secret(newGuess));
        return new Result(cows, bulls);
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
