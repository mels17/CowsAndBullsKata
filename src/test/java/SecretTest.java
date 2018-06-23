import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class SecretTest {

    @Test
    public void canConstructSecretWithValue() {
        assertNotNull(new Secret("1234"));
    }

    @Test
    public void canCompareTwoIdenticalSecrets() {
        assertEquals(new Secret("1234"), new Secret("1234"));
    }

    @Test
    public void canCompareTwoDifferentSecrets() {
        assertNotEquals(new Secret("1234"), new Secret("8974"));
    }
}
