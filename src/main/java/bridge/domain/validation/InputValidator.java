package bridge.domain.validation;

import static bridge.domain.constants.GameCommands.QUIT_GAME_COMMAND;
import static bridge.domain.constants.GameCommands.RETRY_GAME_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_DOWN_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_UP_COMMAND;

public class InputValidator {

    static final String INPUT_ONLY_NUMBERS = "숫자만 입력해 주세요.";
    static final String NOT_VALID_RANGE_OF_BRIDGE_SIZE = "다리의 길이는 3 이상 20 이하여야 합니다.";
    static final String NOT_VALID_MOVE_COMMANDS = "U 또는 D만 입력해 주세요. (U:위, D:아래)";
    static final String NOT_VALID_GAME_COMMANDS = "R 또는 Q만 입력해 주세요. (R:재시작, Q:종료)";

    private InputValidator() {
    }

    public static void validateThisIsNumber(String inputValue) {
        final String REGEX_FOR_NUMBER = "^\\d+$";
        if (!inputValue.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBERS);
        }
    }

    public static void validateBridgeSize(int size) {
        final int MIN_SIZE = 3;
        final int MAX_SIZE = 20;
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException(NOT_VALID_RANGE_OF_BRIDGE_SIZE);
        }
    }

    public static void validateCorrectValueForMoving(String inputValue) {
        if (!inputValue.equals(MOVE_UP_COMMAND) && !inputValue.equals(MOVE_DOWN_COMMAND)) {
            throw new IllegalArgumentException(NOT_VALID_MOVE_COMMANDS);
        }
    }

    public static void validateCorrectValueForGameCommand(String inputValue) {
        if (!inputValue.equals(RETRY_GAME_COMMAND) && !inputValue.equals(QUIT_GAME_COMMAND)) {
            throw new IllegalArgumentException(NOT_VALID_GAME_COMMANDS);
        }
    }
}
