package bridge;

public class OutputView {
    private static final String TEXT_GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String PROMPT_FOR_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String PROMPT_FOR_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public void printGameStart() {
        System.out.println(TEXT_GAME_START);
    }

    public void printPromptForBridgeSize() {
        System.out.println(PROMPT_FOR_BRIDGE_SIZE);
    }

    public void printPromptForMove() {
        System.out.println(PROMPT_FOR_MOVE);
    }

    public void printMap() {
    }

    public void printResult() {
    }
}
