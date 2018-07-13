import java.util.Objects;

public class Result {
    final int cows;
    final int bulls;

    public Result(int cows, int bulls) {
        this.cows = cows;
        this.bulls = bulls;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Result) {
            return (((Result) o).cows == this.cows
                    && ((Result) o).bulls == this.bulls);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[c:%d , b:%d]", cows, bulls);
    }
}
