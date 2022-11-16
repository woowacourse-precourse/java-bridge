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

    private void validateCommand (String command) {
        if (command.equals("R") || command.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoving (String moving) {
        if (moving.equals("U") || moving.equals("D")) {
            throw new IllegalArgumentException();
        }
    }
}
