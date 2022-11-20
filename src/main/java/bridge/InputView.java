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

    private void validateBridgeSize() {

    }

    private boolean isDecimal() {
        return true;
    }

    private boolean isInRange() {
        return true;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    private void validateMoving() {

    }

    private boolean isUpOrDown() {
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        return true;
    }

    private void validateGameCommand() {

    }

    private boolean isRetryOrQuit() {
        return true;
    }
}
