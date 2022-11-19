package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String BRIDGE_SIZE_INPUT_ERROR = "[ERROR] 2자리의 숫자로 입력해주세요.";
    private static final String WRONG_MOVING_MARK_INPUT_ERROR = "[ERROR] U 혹은 D를 입력해주세요.";
    private static final String WRONG_RETRY_INPUT_ERROR = "[ERROR] U 혹은 D를 입력해주세요.";

    public int readBridgeSize() {
        String bridgeSizeInput = input();

        validateBridgeSizeInput(bridgeSizeInput);
        return Integer.valueOf(bridgeSizeInput);
    }

    private void validateBridgeSizeInput(String bridgeSizeInput) {
        String match = "^\\d{1,2}$";
        if (!bridgeSizeInput.matches(match)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR);
        }
    }

    public String readMoving() {
        String selectUpOrDownInput = input();

        validateMovingInput(selectUpOrDownInput);
        return selectUpOrDownInput;
    }

    private void validateMovingInput(String selectUpOrDownInput) {
        String match = "^[U|D]$";
        if (!selectUpOrDownInput.matches(match)) {
            throw new IllegalStateException(WRONG_MOVING_MARK_INPUT_ERROR);
        }
    }

    public String readGameCommand() {
        String gameCommandInput = input();

        validateGameCommandInput(gameCommandInput);
        return gameCommandInput;
    }

    private void validateGameCommandInput(String gameCommandInput) {
        String match = "^[R|Q]$";
        if (!gameCommandInput.matches(match)) {
            throw new IllegalStateException(WRONG_RETRY_INPUT_ERROR);
        }
    }

    private String input() {
        return Console.readLine();
    }
}
