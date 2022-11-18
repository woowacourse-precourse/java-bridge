package bridge.model;

import java.util.Objects;

public class BridgeSize {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final int value;

    public BridgeSize(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException();
        }
        validate(value);

        this.value = Integer.parseInt(value);
    }

    public int getBridgeSize() {
        return value;
    }

    private void validate(String value) {
        if (value.length() > 2) {
            throw new IllegalArgumentException();
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(value) < MIN_SIZE || Integer.parseInt(value) > MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
