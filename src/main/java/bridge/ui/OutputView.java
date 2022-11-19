package bridge.ui;

import bridge.domain.BridgeGame;
import bridge.domain.MoveCommand;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final static String UP = MoveCommand.UP.getCommand();
    private final static String DOWN = MoveCommand.DOWN.getCommand();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame, boolean isGameSuccess) {
        StringBuilder upperBridgeMap = addBridgeMap(bridgeGame, isGameSuccess, UP);
        StringBuilder lowerBridgeMap = addBridgeMap(bridgeGame, isGameSuccess, DOWN);
        String bridgeMap = upperBridgeMap + "\n" + lowerBridgeMap;

        System.out.println(bridgeMap + "\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame, boolean isGameSuccess) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame, isGameSuccess);

        System.out.print("게임 성공 여부: ");
        printSuccessOrFail(isGameSuccess);

        System.out.println("총 시도한 횟수: " + bridgeGame.getCount());
    }

    private static void printSuccessOrFail(boolean isGameSuccess) {
        if (isGameSuccess) {
            System.out.println("성공");
            return;
        }
        System.out.println("실패");
    }

    private static StringBuilder addBridgeMap(BridgeGame bridgeGame, boolean isGameSuccess, String state) {
        StringBuilder bridgeMap = new StringBuilder();

        bridgeMap.append("[");
        bridgeMap.append(addMiddleBridgeMap(bridgeGame, state));
        bridgeMap.append(addEdgeBridgeMap(bridgeGame, isGameSuccess, state));

        return bridgeMap;
    }

    private static StringBuilder addMiddleBridgeMap(BridgeGame bridgeGame, String state) {
        StringBuilder bridgeMap = new StringBuilder();
        for (int mapIndex = 0; mapIndex < bridgeGame.getCurrentBridgeIndex() - 1; mapIndex++) {
            String currentBridgeState = bridgeGame.getBridge().get(mapIndex);
            if (state.equals(currentBridgeState)) {
                bridgeMap.append(" O |");
                continue;
            }
            bridgeMap.append("   |");
        }
        return bridgeMap;
    }

    private static String addEdgeBridgeMap(BridgeGame bridgeGame, boolean isGameSuccess, String state) {
        String edgeBridgeState = bridgeGame.getBridge().get(bridgeGame.getCurrentBridgeIndex() - 1);

        if (isGameSuccess && state.equals(edgeBridgeState)) {
            return " O ]";
        }
        if (!isGameSuccess && !state.equals(edgeBridgeState)) {
            return " X ]";
        }
        return "   ]";
    }
}
