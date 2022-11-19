package bridge;

public class InputView {
    private static final String PROMPT_FOR_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";

    public void printPromptForBridgeLength() {
        System.out.println(PROMPT_FOR_BRIDGE_LENGTH);
    }

    public int readBridgeSize() {
        return 0;
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}
