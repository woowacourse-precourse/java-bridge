package bridge.domain;

import java.util.Objects;

public class Count {
    private static final String MINIMUM_COUNT_ERROR = "[ERROR] 게임 총 횟수는 1미만이 될 수 없습니다";
    private static final int MINIMUM_COUNT = 1;
    private final int count;

    public Count() {
        this(MINIMUM_COUNT);
    }

    public Count(int count) {
        validateCount(count);
        this.count = count;
    }

    public Count increase() {
        return new Count(this.count + 1);
    }

    public String printCount() {
        return String.valueOf(this.count);
    }

    private void validateCount(int count) {
        if (count < MINIMUM_COUNT) {
            throw new IllegalArgumentException(MINIMUM_COUNT_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
