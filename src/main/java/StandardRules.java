public class StandardRules implements Rules {
    @Override
    public boolean gameOver(int secretLength, int noOfBulls) {
        return secretLength == noOfBulls;
    }
}
