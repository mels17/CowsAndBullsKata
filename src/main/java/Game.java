public class Game {

    public void start() {
        System.out.println("Game started...");
        Secret secret = getSecret();
        System.out.println("Secret created:" + secret);
        Result result = new Result(0, 0);
         do {
            Secret guess = getGuess();
             System.out.println("Guess" + guess);
            result = compare(secret, guess);
             System.out.println("Result" + result);
        } while (!gameOver(result));
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
        return new Secret("1234");
    }

    private Secret getSecret() {
        return new Secret("1234");
    }
}
