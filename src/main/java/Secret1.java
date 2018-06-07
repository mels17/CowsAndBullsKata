import java.util.Arrays;
import java.util.List;

public class Secret1 {
    // This is the first step - random number
    // What is the _secret here? - four-digit number from the digits 0 to 9 without duplication
    // Only this class knows what the right answer is => checking whether the user's guess was right or not, happens here
    // In short, we generate a _secret here and compare whether the user guesses it right or not.



    private int _secret;

    public Secret1() {
        _secret = generateSecret();
    }

    // Problems with testing - randomly generated number and it's a private method
    private int generateSecret() {
        return 1234;
    }

    // Why can't I test it
    public List<String> checkGuess(int guess) {
        return Arrays.asList("C", "B", "C", "B");
    }
}
