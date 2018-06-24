import java.util.*;
import java.util.stream.Collectors;

public class Secret3 {
    private int _secret;

    // For the game
    public Secret3() {
        _secret = generateRandomSecret();
    }

    // For the user
    public Secret3(int _secret) throws Exception {
        if (hasDuplicates(_secret)) throw new Exception("Secret has duplicates");
        this._secret = _secret;
    }

    private boolean hasDuplicates(int secret) {
        String numberString = Integer.valueOf(secret).toString();
        String[] digits = numberString.split("");
        return Arrays.stream(digits).distinct().count() != 4;
    }

    private int generateRandomSecret() {
        return selectFourDigitNumber(shuffleNumbers());
    }

    private List<Integer> shuffleNumbers() {
        List<Integer> shuffledList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

    private Integer selectFourDigitNumber(List<Integer> shuffledList) {
        return Integer.valueOf(shuffledList.subList(0, 4).stream()
                .map(e -> e.toString())
                .collect(Collectors.joining("")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secret3 secret3 = (Secret3) o;
        return _secret == secret3._secret;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_secret);
    }
}
