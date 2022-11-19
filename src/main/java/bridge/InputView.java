package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String TEXT_GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String PROMPT_FOR_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";

    public void printGameStart() {
        System.out.println(TEXT_GAME_START);
    }

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
