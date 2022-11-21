package bridge.view;

import java.util.List;

public class OutputView {

    private static final String PRINT_GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_DIRECTION_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String BridgeStart = "[ ";
    private static final String BridgeEnd = "]\n";

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

    public static void inputMoveDirection() {
        System.out.println(INPUT_MOVE_DIRECTION_MESSAGE);
    }

    public static void printMoveResult(List<List<String>> map) {
        for(List<String> layer : map){
            System.out.print(BridgeStart);
            for(String result : layer){
                System.out.print(result+" ");
            }
            System.out.print(BridgeEnd);
        }
    }
}
