package bridge;

import bridge.UserInput.BridgeSelection;

public class InputValidation {
    public static void validateBridgeSize(int inputSize) {
        if (inputSize < 3 || inputSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    public static void validateUpDown(String inputUpDown) {
        if (!inputUpDown.equals(BridgeSelection.Up.get()) && !inputUpDown.equals(BridgeSelection.Down.get())) {
            throw new IllegalArgumentException("[ERROR] U 또는 D만 입력 가능합니다.(위: U, 아래: D)");
        }
    }

    public static void validateCommand(String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력 가능합니다.(재시도: R, 종료: Q)");
        }
    }
}