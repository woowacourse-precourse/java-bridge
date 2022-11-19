package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String PROMPT_FOR_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public void printPromptForBridgeLength() {
        System.out.println(PROMPT_FOR_BRIDGE_LENGTH);
    }

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
}
