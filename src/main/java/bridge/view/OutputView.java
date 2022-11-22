package bridge.view;

import bridge.model.BridgeGame;
import bridge.model.constant.BridgeConstant;
import bridge.model.constant.BridgeMovable;
import bridge.model.constant.BridgeSpace;
import bridge.view.constant.GameResult;
import bridge.view.constant.Message;
import bridge.view.constant.OutputViewConstant;
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
    public void printMap(List<String> bridge, List<String> map) {
        List<String> upAndDownBridges = setUpAndDownBridges(bridge, map);
        String upBridge = upAndDownBridges.get(OutputViewConstant.UP_BRIDGE_INDEX);
        String downBridge = upAndDownBridges.get(OutputViewConstant.DOWN_BRIDGE_INDEX);
        System.out.println(BridgeConstant.BRIDGE_START + upBridge + BridgeConstant.BRIDGE_END);
        System.out.println(BridgeConstant.BRIDGE_START + downBridge + BridgeConstant.BRIDGE_END);
    }

    private List<String> setUpAndDownBridges(List<String> bridge, List<String> map) {
        String upBridge = "";
        String downBridge = "";
        for (int i = 0; i < map.size(); i++) {
            List<String> bridges = addMovable(bridge.get(i), map.get(i), List.of(upBridge, downBridge));
            upBridge = addSeperator(i, map.size(), bridges.get(OutputViewConstant.UP_BRIDGE_INDEX));
            downBridge = addSeperator(i, map.size(), bridges.get(OutputViewConstant.DOWN_BRIDGE_INDEX));
        }
        return List.of(upBridge, downBridge);
    }

    private List<String> addMovable(String bridgeSpace, String mapSpace, List<String> bridges) {
        String upBridge = bridges.get(OutputViewConstant.UP_BRIDGE_INDEX);
        String downBridge = bridges.get(OutputViewConstant.DOWN_BRIDGE_INDEX);
        upBridge = upBridge.concat(BridgeMovable.get(bridgeSpace.equals(BridgeSpace.UP.getValue()),
                mapSpace.equals(BridgeSpace.UP.getValue())).getValue());
        downBridge = downBridge.concat(BridgeMovable.get(bridgeSpace.equals(BridgeSpace.DOWN.getValue()),
                mapSpace.equals(BridgeSpace.DOWN.getValue())).getValue());
        return List.of(upBridge, downBridge);
    }

    private String addSeperator(int index, int size, String map) {
        if (index != size - 1) {
            return map.concat(BridgeConstant.BRIDGE_SEPERATOR);
        }
        return map;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> map, BridgeGame bridgeGame) {
        System.out.println(Message.GAME_RESULT_TITLE);
        printMap(bridge, map);
        System.out.println(Message.GAME_RESULT_STATUS + GameResult.get(bridgeGame.isSuccess()).getValue());
        System.out.println(Message.GAME_RESULT_COUNT + bridgeGame.getCountOfAttempts());
    }

    public void printGameStart() {
        System.out.println(Message.GAME_START + Message.NEW_LINE);
    }

    public void printInputBridgeSize() {
        System.out.println(Message.INPUT_BRIDGE_SIZE);
    }

    public void printInputBridgeSpace() {
        System.out.println(Message.INPUT_BRIDGE_SPACE);
    }

    public void printInputGameRetry() {
        System.out.println(Message.INPUT_GAME_RETRY);
    }
}
