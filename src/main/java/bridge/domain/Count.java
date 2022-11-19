package bridge.domain;

import java.util.Objects;

public class Count {
    private final int count;

    public Count() {
        this(1);
    }

    public Count(int count) {
        validate(count);
        this.count = count;
    }

    public Count increase() {
        return new Count(this.count + 1);
    }

    public String printCount() {
        return String.valueOf(this.count);
    }

    private void validate(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("[ERROR] 게임 총 횟수는 1미만이 될 수 없습니다");
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
