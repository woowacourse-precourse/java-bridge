package bridge.utils;

import static bridge.utils.message.ErrorMessagesUtil.MOVING;

public enum Move {
    UP("U"),
    DOWN("D"),
    SUCCESS("O"),
    SUCCESS_TEXT("성공"),
    FAIL("X"),
    FAIL_TEXT("실패"),
    NO_MOVE(" ");

    private final String text;

    Move(String text) {
        this.text = text;
    }

    public static Move getMove(String move) {
        if (move.equals(UP.text)) {
            return UP;
        }
        return DOWN;
    }

    public String getText() {
        return text;
    }

    public static void validateMove(String move) {
        if (UP.text.equals(move) || DOWN.text.equals(move)) {
            return;
        }
        throw new IllegalArgumentException(MOVING.getMessage());
    }

    public static boolean isMoveUp(Move moving) {
        return moving == UP;
    }

    public boolean isFail() {
        if (this == FAIL) {
            return true;
        }
        return false;
    }

    public String getResultText() {
        if (this == SUCCESS) {
            return SUCCESS_TEXT.text;
        }
        return FAIL_TEXT.text;
    }
}
