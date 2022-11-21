package bridge.model;

import java.util.Objects;

public class TrialCount {
    private final int count;

    public TrialCount(int count) {
        this.count = count;
    }

    public static TrialCount firstTrial() {
        return new TrialCount(1);
    }

    public TrialCount increase() {
        return new TrialCount(count + 1);
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
