package bridge.view;

public class OutputView {

    private static final String PRINT_GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public void printMap() {
    }

    public void printResult() {
    }

    public static void printGameStart() {
        System.out.println(PRINT_GAME_START_MESSAGE);
    }

    public static void inputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public static void inputMove() {
        System.out.println(INPUT_MOVE_MESSAGE);
    }

}
