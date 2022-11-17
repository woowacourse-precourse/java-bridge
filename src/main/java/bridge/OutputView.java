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
        System.out.println("최종 게임 결과");
        printMap(bridgeGame, successGame);
        System.out.print("게임 성공 여부: ");
        if (successGame) {
            System.out.println("성공");
        }
        if (!successGame) {
            System.out.println("실패");
        }
        System.out.println("총 시도한 횟수: "+bridgeGame.getCount());
    }


    private static StringBuilder addBridgeMap(BridgeGame bridgeGame, boolean successGame, State state) {
        StringBuilder bridgeMap = new StringBuilder();
        bridgeMap.append("[");
        addMiddleBridge(bridgeMap, bridgeGame, state);
        bridgeMap.append(addEdgeBridge(bridgeGame ,successGame, state));
        return bridgeMap;
    }

    private static void addMiddleBridge(StringBuilder bridgeMap, BridgeGame bridgeGame, State state) {
        for (int mapIndex = 0; mapIndex < bridgeGame.getCurrentBridgeIndex() - 1; mapIndex++) {
            if (Objects.equals(bridgeGame.getBridge().get(mapIndex), state.getCode())) {
                bridgeMap.append(" O ");
            }
            if (!Objects.equals(bridgeGame.getBridge().get(mapIndex), state.getCode())) {

                bridgeMap.append("   ");
            }
            bridgeMap.append("|");
        }
    }

    private static String addEdgeBridge(BridgeGame bridgeGame, boolean successGame, State state) {
        String edgeBridgeCode = bridgeGame.getBridge().get(bridgeGame.getCurrentBridgeIndex() - 1);
        if (successGame && Objects.equals(state.getCode(), edgeBridgeCode)) {
            return " O ]";
        }
        if (!successGame && !Objects.equals(state.getCode(), edgeBridgeCode)) {
            return " X ]";
        }
        return "   ]";
    }
}
