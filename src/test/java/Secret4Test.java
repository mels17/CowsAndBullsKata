import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Secret4Test {
    @Test
    public void twoObjectsWithSameSecretAreEqual() {
        assertEquals(new Secret4(Arrays.asList("1", "2", "3", "4")), new Secret4(Arrays.asList("1", "2", "3", "4")));
    }

    @Test
    public void twoObjectsWithDifferentSecretsAreNotEqual() {
        assertNotEquals(new Secret4(Arrays.asList("1", "2", "3", "4")), new Secret4(Arrays.asList("9", "9", "9", "1")));
    }
}
