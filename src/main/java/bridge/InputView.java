package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String PROMPT_FOR_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";

    public void printPromptForBridgeLength() {
        System.out.println(PROMPT_FOR_BRIDGE_LENGTH);
    }

    public String readBridgeLength() {
        return readLine();
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}
