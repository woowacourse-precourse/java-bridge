package bridge.domain;

public class NumberOfTry {
    private int count;

    public NumberOfTry() {
        count = 1;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }
}
