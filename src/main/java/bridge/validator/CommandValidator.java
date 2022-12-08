package bridge.validator;

import bridge.MoveCommand;

public class CommandValidator {
    private final static String RETRY = "R";
    private final static String QUIT = "Q";
    private final static String INVALID_MOVE_TYPE_ERROR_MESSAGE = "[ERROR] 이동할 칸은 U와 D로만 입력할 수 있습니다.";
    private final static String INVALID_RETRY_TYPE_ERROR_MESSAGE = "[ERROR] 게임 재시작 여부는 R과 Q로만 입력할 수 있습니다.";

    public static void validateInvalidType(String input) {
        if (!input.equals(MoveCommand.TOP.getMoveCommand()) && !input.equals(MoveCommand.BOTTOM.getMoveCommand())) {
            throw new IllegalArgumentException(INVALID_MOVE_TYPE_ERROR_MESSAGE);
        }
    }

    public static void validateInvalidRetryType(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(INVALID_RETRY_TYPE_ERROR_MESSAGE);
        }
    }
}
