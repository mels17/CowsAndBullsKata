import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game = new Game(new ConsoleReader(), new ConsoleWriter(), new RandomNumberSecretFactory());

    @Test
    public void canCompareAllBulls() {
        Result actual = game.compare(new Secret("1234"), new Secret("1234"));
        Result expected = new Result(0, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void whenCompareCompletelyDifferentValuesReturn0CAnd0B() {
        Result actual = game.compare(new Secret("1234"), new Secret("5678"));
        Result expected = new Result(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void canCompareAllCows() {
        Result actual = game.compare(new Secret("1234"), new Secret("2143"));
        Result expected = new Result(4, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void whenOneInCorrctPositionAndOnePresentReturn1CAnd1B() {
        Result actual = game.compare(new Secret("1220"), new Secret("2000"));
        Result expected = new Result(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void when2OutOfPlaceAndOneCorrectReturn2CAnd1B() {
        Result actual = game.compare(new Secret("1345"), new Secret("1436"));
        Result expected = new Result(2, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void whenDigitInSamePositionAndPresentThenCountedInBulls() {
        Result actual = game.compare(new Secret("1300"), new Secret("2400"));
        Result expected = new Result(0, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void whenSecretAndGuessOfDifferentLengthReturn0CAnd0B() {
        Result actual = game.compare(new Secret("1222"), new Secret("123"));
        Result expected = new Result(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void whenSecretAndGuessOfDifferentCharactersReturn0CAnd0B() {
        Result actual = game.compare(new Secret("1222"), new Secret("abcd"));
        Result expected = new Result(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void whenAllDigitsAreSame() {
        Result actual = game.compare(new Secret("0000"), new Secret("0000"));
        Result expected = new Result(0, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void example() {
        Result actual = game.compare(new Secret("1807"), new Secret("7810"));
        Result expected = new Result(3, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        Result actual = game.compare(new Secret("1123"), new Secret("0111"));
        Result expected = new Result(1, 1);
        assertEquals(expected, actual);
    }
}
