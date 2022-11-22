package bridge.view;

import bridge.BridgeGame;
import bridge.constant.enumtype.BridgeGameRule;
import bridge.constant.enumtype.UIMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> movedBridge) {
        System.out.print(UIMessage.INFO_BRIDGE_OPEN.getValue());
        Map<String, List<String>> comparedBridge = new HashMap<>();
        printMapUp(bridge, movedBridge, comparedBridge);
        System.out.println(UIMessage.INFO_BRIDGE_CLOSE.getValue());
        System.out.print(UIMessage.INFO_BRIDGE_OPEN.getValue());
        printMapDown(bridge, movedBridge, comparedBridge);
        System.out.println(UIMessage.INFO_BRIDGE_CLOSE.getValue());
        System.out.println();
    }

    private void printMapUp(List<String> bridge, List<String> movedBridge, Map<String, List<String>> comparedBridge) {
        comparedBridge.put("bridge", bridge);
        comparedBridge.put("movedBridge", movedBridge);
        for (int i = 0; i < movedBridge.size(); i++) {
            System.out.print(bridgeCellCharacter(i, BridgeGameRule.MOVE_UP.getValue(), comparedBridge));
            if (i + 1 != movedBridge.size()) {
                System.out.print(UIMessage.INFO_BRIDGE_SEPARATED.getValue());
            }
        }
    }

    private void printMapDown(List<String> bridge, List<String> movedBridge, Map<String, List<String>> comparedBridge) {
        comparedBridge.put("bridge", bridge);
        comparedBridge.put("movedBridge", movedBridge);
        for (int i = 0; i < movedBridge.size(); i++) {
            System.out.print(bridgeCellCharacter(i, BridgeGameRule.MOVE_DOWN.getValue(), comparedBridge));
            if (i + 1 != movedBridge.size()) {
                System.out.print(UIMessage.INFO_BRIDGE_SEPARATED.getValue());
            }
        }
    }

    private String bridgeCellCharacter(int index, String moveCellCharacter, Map<String, List<String>> comparedBridge) {
        String bridgeCell = " ";
        if (comparedBridge.get("bridge").get(index).equals(moveCellCharacter) && comparedBridge.get("movedBridge").get(index).equals(UIMessage.INFO_BRIDGE_MOVE_SUCCESS.getValue())) {
            bridgeCell = UIMessage.INFO_BRIDGE_MOVE_SUCCESS.getValue();
        }
        if (comparedBridge.get("bridge").get(index).equals(moveCellCharacter) && comparedBridge.get("movedBridge").get(index).equals(UIMessage.INFO_BRIDGE_MOVE_FAILED.getValue())) {
            bridgeCell = UIMessage.INFO_BRIDGE_MOVE_FAILED.getValue();
        }
        return bridgeCell;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> movedBridge, Boolean isPassedMoving) {
        System.out.println(UIMessage.INFO_GAME_RESULT.getValue());
        printMap(bridge, movedBridge);
        String isPassed = UIMessage.INFO_GAME_FAILED.getValue();
        if (isPassedMoving) {
            isPassed = UIMessage.INFO_GAME_SUCCESS.getValue();
        }
        System.out.println(UIMessage.INFO_GAME_IS_SUCCESS.getValue() + isPassed);
        System.out.println(UIMessage.INFO_RETRY_COUNT.getValue() + BridgeGame.getBridgeGamePlayCount());
    }
}
