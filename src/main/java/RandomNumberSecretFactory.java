import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberSecretFactory implements SecretFactory {
    public Secret create() {
        return new Secret(randomSecret());
    }

    private String randomSecret(){
        return concatenateListOfString(
                convertIntegersToString(
                        getFourRandomIntegers()));
    }


    private int getRandomIntegerFrom0To9() {
        return new Random().nextInt(10);
    }

    private List<Integer> getFourRandomIntegers() {
        List<Integer> randomInts = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            randomInts.add(getRandomIntegerFrom0To9());
        }
        return randomInts;
    }

    private List<String> convertIntegersToString(List<Integer> integers) {
        return integers
                .stream()
                .map(i -> Integer.toString(Integer.valueOf(i)))
                .collect(Collectors.toList());
    }

    private String concatenateListOfString(List<String> strings) {
        return String.join("", strings);
    }
}
