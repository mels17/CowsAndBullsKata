import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Secret1Test {

    @Test
    public void secretWithSameNumberAreEqual() throws Exception {
        System.out.print("ABD");
        Secret3 s1 = new Secret3(1234);
        Secret3 s2 = new Secret3(1234);
        assertEquals(s1, s2);
    }

    @Test
    public void secretsCanBeRandomlyGenerated() {
        Secret3 s1 = new Secret3();
        Secret3 s2 = new Secret3();
        assertNotEquals(s1, s2);
    }

    @Test(expected = Exception.class)
    public void secretWithDuplicatesWillThrow() throws Exception {
        Secret3 s1 = new Secret3(1111);
    }
}
