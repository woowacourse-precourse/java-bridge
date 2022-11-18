package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String bridgeSizeInputExceptionMessage = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String movingInputExceptionMessage = "U와 D 중 하나로 입력해야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateBridgeSizeInput(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(bridgeSizeInputExceptionMessage);
        }
        int integerInput = Integer.parseInt(input);
        if (integerInput > 20 || integerInput < 3) {
            throw new IllegalArgumentException(bridgeSizeInputExceptionMessage);
        }
    }

    private void validateMovingInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(movingInputExceptionMessage);
        }
    }
}
