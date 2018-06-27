public class Game {

    public void start() {
        Secret secret = getSecret();
        Secret guess = getGuess();
        Result result = compare(secret, guess);
        //Winner or not(Play again?)?
    }

    private Result compare(Secret secret, Secret guess) {
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < 4; i++) {
            char guessChar = guess.getSecretValue().charAt(i);
            if(guessChar == secret.getSecretValue().charAt(i)) {
                bulls++;
            } else if(secret.getSecretValue().contains(Character.toString(guessChar))) {
                int count = (int)secret.getSecretValue().chars().filter(num -> num == guessChar).count();
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
