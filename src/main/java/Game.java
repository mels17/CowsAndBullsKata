public class Game {

    private Reader reader;
    private Writer writer;
    public Game(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void start() {
        printWelcomeMessage();
        Secret secret = getSecret();
        Result result = new Result(0, 0);
         do {
             printWelcomeMessage();
             Secret guess = getGuess();
            result = compare(secret, guess);
             printResult(result);
         } while (!gameOver(result));
    }

    private void printWelcomeMessage() {
        writer.write("Game started...");
    }

    private void printResult(Result result) {
        writer.write("Result: " + result);
    }

    private void printGuessInputMessage() {
        writer.write("Enter guess: ");
    }
    private boolean gameOver(Result result) {
        return result.bulls == 4;
    }



    public Result compare(Secret secret, Secret guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < 4; i++) {
            char guessChar = guess.secretValue.charAt(i);
            if (guessChar == secret.secretValue.charAt(i)) {
                bulls++;
            } else if (secret.secretValue.contains(Character.toString(guessChar))) {
                int count = (int) secret.secretValue.chars().filter(num -> num == guessChar).count();
                cows += count;
            }
        }
        return new Result(cows, bulls);
    }

    private Secret getGuess() {
        printGuessInputMessage();
        return new Secret(reader.read());
    }

    private Secret getSecret() {
        return RandomSecretFactory.create();
    }
}
