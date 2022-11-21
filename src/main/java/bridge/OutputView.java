package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String changeFailToX(String playerStep) {
        String output = "O";
        if (playerStep.length() > 1) {
            output = "X";
        }
        return output;
    }

    public void SplitBridgeToUpBridge(List<String> upBridgeMap, List<String> downBridgeMap, String playerStep) {
        if (playerStep.charAt(playerStep.length() - 1) == 'U') {
            upBridgeMap.add(changeFailToX(playerStep));
            downBridgeMap.add(" ");
        }
    }

    public void SplitBridgeToDownBridge(List<String> upBridgeMap, List<String> downBridgeMap, String playerStep) {
        if (playerStep.charAt(playerStep.length() - 1) == 'D') {
            upBridgeMap.add(" ");
            downBridgeMap.add(changeFailToX(playerStep));
        }
    }


    public void splitMap(List<String> upBridgeMap, List<String> downBridgeMap, String playerStep) {
        SplitBridgeToUpBridge(upBridgeMap, downBridgeMap, playerStep);
        SplitBridgeToDownBridge(upBridgeMap, downBridgeMap, playerStep);
    }

    private void printMap(List<String> upBridgeMap, List<String> downBridgeMap) {
        System.out.println("[ " + String.join(" | ", upBridgeMap) + " ]");
        System.out.println("[ " + String.join(" | ", downBridgeMap) + " ]");
    }

    public void constructMap(List<String> playerMap) {
        List<String> upBridgeMap = new ArrayList<>();
        List<String> downBridgeMap = new ArrayList<>();
        for (String playerStep : playerMap) {
            splitMap(upBridgeMap, downBridgeMap, playerStep);
        }
        printMap(upBridgeMap, downBridgeMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
