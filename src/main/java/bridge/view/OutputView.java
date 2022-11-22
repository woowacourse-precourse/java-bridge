package bridge.view;

import bridge.constant.enumtype.BridgeGameRule;
import bridge.constant.enumtype.UIMessage;
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
    public void printMap(List<String> bridge, List<String> movedBridge) {
        System.out.print(UIMessage.INFO_BRIDGE_OPEN.getValue());
        printMapUp(bridge, movedBridge);
        System.out.println(UIMessage.INFO_BRIDGE_CLOSE.getValue());
        System.out.print(UIMessage.INFO_BRIDGE_OPEN.getValue());
        printMapDown(bridge, movedBridge);
        System.out.println(UIMessage.INFO_BRIDGE_CLOSE.getValue());
    }

    // @TODO: 함수 분리해서 10라인으로 맞추기
    private void printMapUp(List<String> bridge, List<String> movedBridge) {
        for (int i = 0; i < movedBridge.size(); i++) {
            String bridgeCell = " ";
            if (bridge.get(i).equals(BridgeGameRule.MOVE_UP.getValue()) && movedBridge.get(i).equals(UIMessage.INFO_BRIDGE_MOVE_SUCCESS.getValue())) {
                bridgeCell = UIMessage.INFO_BRIDGE_MOVE_SUCCESS.getValue();
            }
            if (bridge.get(i).equals(BridgeGameRule.MOVE_UP.getValue()) && movedBridge.get(i).equals(UIMessage.INFO_BRIDGE_MOVE_FAILED.getValue())) {
                bridgeCell = UIMessage.INFO_BRIDGE_MOVE_FAILED.getValue();
            }
            System.out.print(bridgeCell);
            if (i + 1 != movedBridge.size()) {
                System.out.print(UIMessage.INFO_BRIDGE_SEPARATED.getValue());
            }
        }
    }

    // @TODO: 함수 분리해서 10라인으로 맞추기
    private void printMapDown(List<String> bridge, List<String> movedBridge) {
        for (int i = 0; i < movedBridge.size(); i++) {
            String bridgeCell = " ";
            if (bridge.get(i).equals(BridgeGameRule.MOVE_DOWN.getValue()) && movedBridge.get(i).equals(UIMessage.INFO_BRIDGE_MOVE_SUCCESS.getValue())) {
                bridgeCell = UIMessage.INFO_BRIDGE_MOVE_SUCCESS.getValue();
            }
            if (bridge.get(i).equals(BridgeGameRule.MOVE_DOWN.getValue()) && movedBridge.get(i).equals(UIMessage.INFO_BRIDGE_MOVE_FAILED.getValue())) {
                bridgeCell = UIMessage.INFO_BRIDGE_MOVE_FAILED.getValue();
            }
            System.out.print(bridgeCell);
            if (i + 1 != movedBridge.size()) {
                System.out.print(UIMessage.INFO_BRIDGE_SEPARATED.getValue());
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> movedBridge, Boolean isPassedMoving) {
    }
}
