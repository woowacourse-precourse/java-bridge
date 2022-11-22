package bridge.model;

import bridge.view.Message;

public enum Moving {
    UP("U"), DOWN("D");

    private final String value;

    Moving(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Moving getMoving(String inputMoving) {
        if (Moving.UP.getValue().equals(inputMoving)) return Moving.UP;
        if (Moving.DOWN.getValue().equals(inputMoving)) return Moving.DOWN;
        throw new IllegalArgumentException(Message.ERROR + Message.MOVE_ERROR);
    }

}
