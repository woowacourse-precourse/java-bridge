package bridge.model;

import java.util.Objects;

public class TrialCount {
    private static final int INITIAL_COUNT = 1;
    private static final int INCREMENT = 1;
    private final int count;

    public TrialCount(int count) {
        this.count = count;
    }

    public static TrialCount firstTrial() {
        return new TrialCount(INITIAL_COUNT);
    }

    public TrialCount increase() {
        return new TrialCount(count + INCREMENT);
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrialCount that = (TrialCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
