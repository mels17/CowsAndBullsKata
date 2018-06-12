import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game4 {

    private static List<String> generateRandomSecret() {
        return selectFirstFourNumbersFromList(shuffleNumbers());
    }

    private static List<String> shuffleNumbers() {
        List<String> shuffledList = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

    private static List<String> selectFirstFourNumbersFromList(List<String> shuffledList) {
        return shuffledList.subList(0, 4);
    }

    public static void main(String... args) {
        Secret4 masterMindSecret = new Secret4(generateRandomSecret());
        Secret4 userSecret = new Secret4(Arrays.asList("1", "2", "3", "4"));
    }
}
