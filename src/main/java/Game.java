import com.sun.deploy.util.StringUtils;

import java.util.stream.Collectors;

public class Game {

    private Reader _reader;
    private Writer _writer;
    private SecretFactory _secretFactory;
    private Rules _rules;

    public Game(Reader reader, Writer writer, SecretFactory secretFactory, Rules rules) {
        _reader = reader;
        _writer = writer;
        _secretFactory = secretFactory;
        _rules = rules;
    }

    public void start() {
        printWelcomeMessage();
        Secret secret = getSecret();
        Result result;
        do {
            printWelcomeMessage();
            Secret guess = getGuess();
            result = secret.compare(guess);
            printResult(result);
        } while (!gameOver(secret.getLengthOfSecret(), result));
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

    private boolean gameOver(int expectedNoOfBulls, Result result) {
        return _rules.gameOver(expectedNoOfBulls, result.bulls);
    }


    private Secret getSecret() {
        printGuessInputMessage();
        return new Secret(_reader.read());
    }

    private Secret getGuess() {
        Secret secret = _secretFactory.create();
        System.out.println(secret);
        return secret;
    }
}
