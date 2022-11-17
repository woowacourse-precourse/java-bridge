package bridge;

import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame, boolean successGame) {
        String bridgeMap = addBridgeMap(bridgeGame, successGame, State.UP) +
                "\n" +
                addBridgeMap(bridgeGame, successGame, State.DOWN);
        System.out.println(bridgeMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame, boolean successGame) {
    }


    private static StringBuilder addBridgeMap(BridgeGame bridgeGame, boolean successGame, State state) {
        StringBuilder bridgeMap = new StringBuilder();
        bridgeMap.append("[");
        addMiddleBridge(bridgeMap, bridgeGame, state);
        addEdgeBridge(bridgeMap, successGame);
        return bridgeMap;
    }

    private static void addMiddleBridge(StringBuilder bridgeMap, BridgeGame bridgeGame, State state) {
        for (int mapIndex = 0; mapIndex < bridgeGame.getCurrentBridgeIndex() - 1; mapIndex++) {
            if (Objects.equals(bridgeGame.getBridge().get(mapIndex), state.getCode())) {
                bridgeMap.append("O ");
            }
            if (!Objects.equals(bridgeGame.getBridge().get(mapIndex), state.getCode())) {
                bridgeMap.append("  ");
            }
        }
        bridgeMap.append("| ");
    }

    private static void addEdgeBridge(StringBuilder bridgeMap, boolean successGame) {
        if (successGame) {
            bridgeMap.append("O ]");
        }
        if (!successGame) {
            bridgeMap.append("X ]");
        }
    }
}
