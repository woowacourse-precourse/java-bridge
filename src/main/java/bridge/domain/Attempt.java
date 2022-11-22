package bridge.domain;

public class Attempt {
    private static final int DEFAULT = 0;
    private int count;

    private Attempt(int count) {
        this.count = count;
    }

    public static Attempt begin() {
        return new Attempt(DEFAULT);
    }

    public void increase() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}
