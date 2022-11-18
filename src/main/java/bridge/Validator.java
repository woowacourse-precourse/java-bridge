package bridge;

public class Validator {
    private static final InputView inputView = new InputView();

    /**
     * 다리 길이의 유효성 검사
     */
    public static void validateInputSize(int bridgeSize) {
        try {
            if (bridgeSize < 3 || bridgeSize > 20) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_SIZE_INPUT_RANGE.getErrorMessage());
            inputView.inputBridgeSize();
        }
    }

    public static void validateInputType(String inputSize) {
        try {
            Integer.parseInt(inputSize);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.BRIDGE_SIZE_INPUT_TYPE.getErrorMessage());
            inputView.inputBridgeSize();
        }
    }

    public static void validateInputNull(String input) {
        try {
            if (input.length() == 0) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println(ErrorMessage.INPUT_NULL.getErrorMessage());
            inputView.inputBridgeSize();
        }
    }

    /**
     * 플레이어가 이동할 칸 유효성 검사
     */
    public static void validateInputDIRECTION(String inputDirection) {
        try {
            if (!inputDirection.equals("U") && !inputDirection.equals("D")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_MOVE_INPUT.getErrorMessage());
            inputView.inputMovingDirection();
        }
    }

    public static void validateInputDirectionLowerCase(String inputDirection) {
        char check = inputDirection.charAt(0);
        try {
            if (!Character.isUpperCase(check)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_MOVE_INPUT_LOWERCASE.getErrorMessage());
            inputView.inputMovingDirection();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부 유효성 검사
     */
    public static void validateInputGameRestart(String inputRestart) {
        try {
            if (!inputRestart.equals("R") && !inputRestart.equals("Q")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_RESTART_INPUT.getErrorMessage());
            inputView.inputGameRestart();
        }
    }
}
