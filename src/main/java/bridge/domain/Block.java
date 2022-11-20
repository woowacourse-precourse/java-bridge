package bridge.domain;

import bridge.ErrorMessage;

/**
 * 다리의 한 칸을 의미하는 클래스
 */

public enum Block {

    DOWN_BRIDGE("D", 0),
    UP_BRIDGE("U", 1);

    private final String string;
    private final int number;

    Block(String string, int number) {
        this.string = string;
        this.number = number;
    }

    public static String from(String moving) {
        validate(moving);
        return moving;
    }

    public String getString() {
        return this.string;
    }

    public int getNumber() {
        return this.number;
    }

    private static void validate(String moving) {
        if (!moving.equals(DOWN_BRIDGE.string) && !moving.equals(UP_BRIDGE.string)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_MOVING_INPUT_ERROR.getMessage());
        }
    }

}
