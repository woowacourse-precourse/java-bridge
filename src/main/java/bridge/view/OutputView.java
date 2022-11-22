package bridge.view;

import java.util.List;
import java.util.stream.Collectors;


public class OutputView {

    private static final String PRINT_GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_DIRECTION_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String BRIDGE_PREFIX = "[ ";
    private static final String BRIDGE_DELIMITER = " | ";
    private static final String BRIDGE_SUFFIX = " ]";

    public static void printMap(List<List<String>> map) {
        for (List<String> mapLayer : map)
            System.out.println(mapLayer.stream().
                    collect(Collectors.joining(BRIDGE_DELIMITER, BRIDGE_PREFIX, BRIDGE_SUFFIX)));
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

    public static void inputGameRestart() {
        System.out.println(INPUT_GAME_RESTART_MESSAGE);
    }

}
