package bridge.utils;

import static bridge.utils.message.ErrorMessagesUtil.MOVING;

public enum Move {
    UP("U"),
    DOWN("D"),
    SUCCESS("O"),
    FAIL("X"),
    NO_MOVE(" ");

    private final String moving;

    Move(String moving) {
        this.moving = moving;
    }

    public static Move getMove(String move) {
        if (move.equals(UP.moving)) {
            return UP;
        }
        return DOWN;
    }

    public String getMoving() {
        return moving;
    }

    public static void validateMove(String move) {
        if (UP.moving.equals(move) || DOWN.moving.equals(move)) {
            return;
        }
        throw new IllegalArgumentException(MOVING.getMessage());
    }

    public static boolean isMoveUp(Move moving) {
        return moving == UP;
    }
}
