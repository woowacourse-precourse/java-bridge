package bridge.view;

import bridge.model.Direction;
import bridge.model.GameCommand;

public class InputValidator {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String NUMBER_PATTERN = "\\d+";

    private InputValidator() {
    }

    public static void validateNumber(String number) {
        if (!number.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public static void validateBridgeSize(int size) {
        if (!isValidSize(size)) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private static boolean isValidSize(int number) {
        return number >= MIN_BRIDGE_SIZE && number <= MAX_BRIDGE_SIZE;
    }

    public static void validateMovingCommand(String command) {
        if (!isValidMovingCommand(command)) {
            throw new IllegalArgumentException("U 또는 D를 입력해주세요.");
        }
    }

    private static boolean isValidMovingCommand(String command) {
        return Direction.UP.isSame(command) || Direction.DOWN.isSame(command);
    }

    public static void validateGameCommand(String command) {
        if (!isValidGameCommand(command)) {
            throw new IllegalArgumentException("R 또는 Q를 입력해주세요.");
        }
    }

    private static boolean isValidGameCommand(String command) {
        return GameCommand.QUIT.isSame(command) || GameCommand.RETRY.isSame(command);
    }
}
