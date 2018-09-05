import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompareTest {
    @Test
    public void canCompareAllBulls() {
        Secret s = new Secret("12345678");
        Result actual = s.compare(new Secret("12345678"));
        Result expected = new Result(0, s.getLengthOfSecret());
        assertEquals(expected, actual);
    }

    @Test
    public void whenCompareCompletelyDifferentValuesReturn0CAnd0B() {
        Result actual = new Secret("1234").compare(new Secret("5678"));
        Result expected = new Result(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void canCompareAllCows() {
        Result actual = new Secret("1234").compare(new Secret("2143"));
        Result expected = new Result(4, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void whenOneInCorrectPositionAndOnePresentReturn1CAnd1B() {
        Result actual = new Secret("1220").compare(new Secret("2000"));
        Result expected = new Result(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void when2OutOfPlaceAndOneCorrectReturn2CAnd1B() {
        Result actual = new Secret("1345").compare(new Secret("1436"));
        Result expected = new Result(2, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void whenDigitInSamePositionAndPresentThenCountedInBulls() {
        Result actual = new Secret("1300").compare(new Secret("2400"));
        Result expected = new Result(0, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void whenSecretAndGuessOfDifferentLengthReturn0CAnd0B() {
        Result actual = new Secret("1222").compare(new Secret("123"));
        Result expected = new Result(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void whenSecretAndGuessOfDifferentCharactersReturn0CAnd0B() {
        Result actual = new Secret("1222").compare(new Secret("abcd"));
        Result expected = new Result(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void whenAllDigitsAreSame() {
        Result actual = new Secret("0000").compare(new Secret("0000"));
        Result expected = new Result(0, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void givenThreeMisplacedDigitsAnd1CorrectlyPlacedDigitReturn3CAnd1B() {
        Result actual = new Secret("1807").compare(new Secret("7810"));
        Result expected = new Result(3, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void givenOneDigitPresentAndOneDigitPresentInCorrectPlaceReturn1CAnd1Bs() {
        Result actual = new Secret("1123").compare(new Secret("0111"));
        Result expected = new Result(1, 1);
        assertEquals(expected, actual);
    }


    @Test
    public void given1234and1111() {
        Result actual = new Secret("1234").compare(new Secret("1111"));
        Result expected = new Result(0, 1);
        assertEquals(expected, actual);
    }



}
