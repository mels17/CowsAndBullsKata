import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Secret1Test {

    @Test
    public void secret() {
        Secret3 s1 = new Secret3(1234);
        Secret3 s2 = new Secret3();
        assertEquals(s1, s2);
    }


}
