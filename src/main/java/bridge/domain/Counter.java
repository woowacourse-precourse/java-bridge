package bridge.domain;

public class Counter {
    private int count = 1;

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    public void reset() {
        count = 1;
    }
}
