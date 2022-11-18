package bridge.domain;

public class Turn {
    private int count = 0;

    public void increase() {
        count++;
    }

    public void clear() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
}
