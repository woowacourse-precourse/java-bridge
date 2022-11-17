package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

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

    private void validateInputIsExist(String input) {
        if (input.length() == 0) {
            throw new IllegalStateException();
        }
    }

    private void validateInputSizeIsInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 48 || input.charAt(i) > 57) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateInputSizeIsInRange(String input) {
        int size = 0;
        for (int i = 0; i < input.length(); i++) {
            size = size * 10 + input.charAt(i) - 48;
        }
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputMovingCharacter(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException();
        }
    }
}
