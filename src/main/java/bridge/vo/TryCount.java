package bridge.vo;

import java.util.Objects;

public class TryCount {
    private final int tryCount;

    public TryCount() {
        tryCount = 0;
    }

    private TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public TryCount addCount() {
        return new TryCount(tryCount + 1);
    }

    @Override
    public String toString() {
        return Integer.toString(tryCount);
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) return true;
        if (!(target instanceof TryCount)) return false;
        TryCount anotherTryCount = (TryCount) target;
        return tryCount == anotherTryCount.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }
}
