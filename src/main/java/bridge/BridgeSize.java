package bridge;

import java.util.Objects;

public class BridgeSize {
    private final int size;

    public BridgeSize(String size) {
        validate(size);
        this.size = Integer.parseInt(size);
    }

    private void validate(final String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자만 입력 가능합니다.");
        }
        int brideSize;
        try {
            brideSize = Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자만 입력 가능합니다.");
        }
        if (brideSize < 3 || brideSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3 이상 20 이하만 입력 가능합니다.");
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
