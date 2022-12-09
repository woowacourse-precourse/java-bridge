package bridge.constant.enums;

import bridge.constant.Message;
import bridge.constant.Message.LogicExceptionMessage;

public enum Moving {

    UP("U", 1),
    DOWN("D", 0);

    private final String value;
    private final int number;

    Moving(String value, int number) {
        this.value = value;
        this.number = number;
    }

    public static String findBy(int directionNumber) {
        for (Moving move : Moving.values()) {
            if (move.getNumber() == (directionNumber)) {
                return move.getValue();
            }
        }
        throw new RuntimeException(LogicExceptionMessage.WRONG_BRIDGE_DIRECTION);
    }

    public String getValue() {
        return value;
    }

    public int getNumber() {
        return number;
    }
}
