import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSecretFactory {


    public static Secret create() {
        Random random = new Random();
        String secret = "";

        return new Secret(secret);
    }

    private static int getRandomIntegerFrom0To9() {
        return new Random().nextInt(10);
    }

    private static List<Integer> getFourRandomIntegers() {
        List<Integer> randomInts = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            randomInts.add(getRandomIntegerFrom0To9());
        }
        return randomInts;
    }

    private static List<String> convertIntegersToString(List<Integer> integers) {
        return new ArrayList<String>();
    }
}
