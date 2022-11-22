package bridge;

import java.util.Objects;

public class BridgeSize {
    public static final int MIN_LENGTH = 3;
    public static final int MAX_LENGTH = 20;
    private final int size;

    public BridgeSize(String size) {
        this.size = validate(size);
        validate(this.size);
    }

    private void validate(final int size) {
        if (size < MIN_LENGTH || size > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3 이상 20 이하만 입력 가능합니다.");
        }
    }

    private int validate(final String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자만 입력 가능합니다.");
        }
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자만 입력 가능합니다.");
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BridgeSize that = (BridgeSize) o;
        return size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}
