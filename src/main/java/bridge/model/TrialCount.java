package bridge.model;

public class TrialCount {
    private final int count;

    public TrialCount(int count) {
        this.count = count;
    }

    public static TrialCount initialCount() {
        return new TrialCount(1);
    }

    public TrialCount increase() {
        return new TrialCount(count + 1);
    }

    public int getCount() {
        return count;
    }
}
