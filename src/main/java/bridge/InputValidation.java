package bridge;

import bridge.Constant.BridgeSelection;
import bridge.Constant.GameCommand;

public class InputValidation {
    private static final String ERROR = "[ERROR]";
    private static final String NOT_IN_RANGE = ERROR + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String NOT_NUMBER = ERROR + "숫자만 입력할 수 있습니다.";
    private static final String WRONG_SELECTION_INPUT = ERROR + "U 또는 D만 입력 가능합니다.(위: U, 아래: D)";
    private static final String WRONG_COMMAND_INPUT = ERROR + "R 또는 Q만 입력 가능합니다.(재시도: R, 종료: Q)";

    public static void validateBridgeSize(int inputSize) {
        if (!(inputSize >= 3 && inputSize <= 20)) {
            throw new IllegalArgumentException(NOT_IN_RANGE);
        }
    }

    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public static void validateUpDown(String inputUpDown) {
        if (!(inputUpDown.equals(BridgeSelection.Up.get()) || inputUpDown.equals(BridgeSelection.Down.get()))) {
            throw new IllegalArgumentException(WRONG_SELECTION_INPUT);
        }
    }

    public static void validateCommand(String command) {
        if (!(command.equals(GameCommand.RETRY.get()) || command.equals(GameCommand.QUIT.get()))) {
            throw new IllegalArgumentException(WRONG_COMMAND_INPUT);
        }
    }
}