package bridge.dto;

import java.util.Objects;

public class TryCountDto {

    private int tryCount;

    public TryCountDto() {
        tryCount = 0;
    }

    public void addCount() {
        ++tryCount;
    }

    @Override
    public String toString() {
        return Integer.toString(tryCount);
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) return true;
        if (!(target instanceof TryCountDto)) return false;
        TryCountDto anotherTryCount = (TryCountDto) target;
        return tryCount == anotherTryCount.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }
}
