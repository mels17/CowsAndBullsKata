import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void canCompareAllBulls() {
        Game game = new Game();
        Result actual = game.compare(new Secret("1234"), new Secret("1234"));
        Result expected = new Result(0, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void canCalculateCows() {
        Game game = new Game();
        Result actual = game.compare(new Secret("1220"), new Secret("2000"));
        // Right Answer - Number of cows is 1
        Result expected = new Result(4, 1);
        assertEquals(expected, actual);
    }



}
