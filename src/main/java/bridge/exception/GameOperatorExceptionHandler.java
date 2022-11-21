package bridge.exception;

import bridge.constants.Direction;

public class GameOperatorExceptionHandler {
    public static void handleNotUOrDException(String input) {
        if (!(input.equals(Direction.UP.getDirection()) ||
                input.equals(Direction.DOWN.getDirection()))) {
            throw new IllegalArgumentException("[ERROR] 입력된 방향이 U 혹은 D가 아닙니다.");
        }
    }

    public static void handleNotROrQException(String input) {
        final String R = "R";
        final String Q = "Q";

        if (!(input.equals(R) || input.equals(Q))) {
            throw new IllegalArgumentException("[ERROR] 입력된 선택이 R 혹은 Q가 아닙니다.");
        }
    }
}
