package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMap;

public class OutputView {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_START = "[";
    private static final String BRIDGE_END = "]";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS_MESSAGE = "성공";
    private static final String GAME_FAIL_MESSAGE = "실패";

    public static void printStartMessage() {
        System.out.println(GAME_START);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeMap bridgeMap) {
        System.out.println(BRIDGE_START + bridgeMap.getUpperBridge() + BRIDGE_END);
        System.out.println(BRIDGE_START + bridgeMap.getLowerBridge() + BRIDGE_END);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeMap bridgeMap, BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT);
        System.out.println(BRIDGE_START + bridgeMap.getUpperBridge() + BRIDGE_END);
        System.out.println(BRIDGE_START + bridgeMap.getLowerBridge() + BRIDGE_END);
        System.out.println();
        System.out.printf("게임 성공 여부: %s%n", getResult(bridgeGame));
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTrialCount());
    }

    private static String getResult(BridgeGame bridgeGame) {
        if (bridgeGame.isGameFinish()) {
            return GAME_SUCCESS_MESSAGE;
        }
        return GAME_FAIL_MESSAGE;
    }
}
