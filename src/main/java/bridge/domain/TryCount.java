package bridge.domain;

import bridge.exception.domain.TryCountRangeException;
import java.util.Objects;

public class TryCount {
    private static final int TRY_COUNT_START = 1;
    private static final int TRY_COUNT_MAX = 2_000_000_000;

    private final int count;

    public TryCount() {
        this(TRY_COUNT_START);
    }

    public TryCount(int count) {
        validateMin(count);
        this.count = count;
    }

    private void validateMin(int count) {
        if (count < TRY_COUNT_START || count > TRY_COUNT_MAX) {
            throw new TryCountRangeException(TRY_COUNT_START, TRY_COUNT_MAX);
        }
    }

    public TryCount plusOne() {
        return new TryCount(this.count + 1);
    }

    public int count() {
        return this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryCount tryCount = (TryCount) o;
        return count == tryCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
