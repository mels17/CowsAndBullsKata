public class Game {

    public void start() {
        Secret secret = getSecret();
        Secret guess = getGuess();
        Result result = compare(secret, guess);
        //Winner or not(Play again?)?
    }

    private Result compare(Secret secret, Secret guess) {
        return new Result();
    }

    private Secret getGuess() {
        return new Secret("1234");
    }

    private Secret getSecret() {
        return new Secret("1234");
    }
}
