package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 시 시작 메시지를 출력한다.
     */
    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int lastLevel, boolean succeeded) {
        System.out.println(buildBridgeMap(bridge, lastLevel, succeeded));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, boolean succeeded, int failedLevel, int tried) {
        System.out.println("최종 게임 결과");
        if (succeeded) System.out.println(buildBridgeMap(bridge, bridge.size()-1, true));
        if (!succeeded) System.out.println(buildBridgeMap(bridge, failedLevel, false));
        System.out.print("\n게임 성공 여부: ");
        if(succeeded) System.out.println("성공");
        if(!succeeded) System.out.println("실패");
        System.out.println("총 시도한 횟수: " + tried);
    }

    public String buildBridgeMap(List<String> bridge, int lastLevel, boolean succeeded) {
        String upperBridge = buildUpperBridgeMap(bridge, lastLevel, succeeded);
        String lowerBridge = buildLowerBridgeMap(bridge, lastLevel, succeeded);

        return upperBridge + "\n" + lowerBridge;
    }

    public String buildUpperBridgeMap(List<String> bridge, int lastLevel, boolean succeeded) {
        StringBuilder bridgeMap = new StringBuilder("[ ");
        for (int i = 0; i < lastLevel; i++) {
            if (bridge.get(i).equals("U")) bridgeMap.append("O | ");
            if (bridge.get(i).equals("D")) bridgeMap.append("  | ");
        }
        if (bridge.get(lastLevel).equals("U") && succeeded) bridgeMap.append("O ]");
        if (bridge.get(lastLevel).equals("U") && !succeeded) bridgeMap.append("  ]");
        if (bridge.get(lastLevel).equals("D") && succeeded) bridgeMap.append("  ]");
        if (bridge.get(lastLevel).equals("D") && !succeeded) bridgeMap.append("X ]");

        return bridgeMap.toString();
    }

    public String buildLowerBridgeMap(List<String> bridge, int lastLevel, boolean succeeded) {
        StringBuilder bridgeMap = new StringBuilder("[ ");
        for (int i = 0; i < lastLevel; i++) {
            if (bridge.get(i).equals("D")) bridgeMap.append("O | ");
            if (bridge.get(i).equals("U")) bridgeMap.append("  | ");
        }
        if (bridge.get(lastLevel).equals("D") && succeeded) bridgeMap.append("O ]");
        if (bridge.get(lastLevel).equals("D") && !succeeded) bridgeMap.append("  ]");
        if (bridge.get(lastLevel).equals("U") && succeeded) bridgeMap.append("  ]");
        if (bridge.get(lastLevel).equals("U") && !succeeded) bridgeMap.append("X ]");

        return bridgeMap.toString();
    }

}
