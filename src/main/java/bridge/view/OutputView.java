package bridge.view;

import bridge.model.BridgeMap;
import bridge.model.Player;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String GAME_FINAL_RESULT_MESSAGE = "최종 게임 결과";
    public static final String GAME_SUCCESS_OR_NOT_MESSAGE = "게임 성공 여부: %s%n";
    public static final String GAME_TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: %d%n";
    public static final String BRIDGE_START_BRACKET = "[ ";
    public static final String BRIDGE_END_BRACKET = " ]";
    public static final String BRIDGE_CONTOUR = " | ";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap() {
        BridgeMap bridgeMap = BridgeMap.getBridgeMap();
        System.out.println(getCurrentBridgeMapStatus(bridgeMap.getUpperBridgeMap()));
        System.out.println(getCurrentBridgeMapStatus(bridgeMap.getLowerBridgeMap()));
        System.out.println();
    }

    private static String getCurrentBridgeMapStatus(List<String> bridgeMap) {
        return BRIDGE_START_BRACKET + String.join(BRIDGE_CONTOUR, bridgeMap) + BRIDGE_END_BRACKET;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(boolean winOrLose, int tryCount) {
        System.out.println(GAME_FINAL_RESULT_MESSAGE);
        printMap();

        System.out.printf(GAME_SUCCESS_OR_NOT_MESSAGE, judgeGameResult(winOrLose));
        System.out.printf(GAME_TOTAL_TRY_COUNT_MESSAGE, tryCount);
    }

    private static String judgeGameResult(boolean win) {
        if (win) {
            return SUCCESS;
        }
        return FAIL;
    }

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
}
