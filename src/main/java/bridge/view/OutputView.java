package bridge.view;

import bridge.type.Bridge;
import bridge.type.TextType;
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
    public void printMap(List<Bridge> bridges) {
        List<String> upBridgeMap = new ArrayList<>();
        List<String> downBridgeMap = new ArrayList<>();

        initMap(bridges.get(0), upBridgeMap, downBridgeMap);

        makeBridgeToMap(bridges, upBridgeMap, downBridgeMap);

        System.out.println(String.join("", upBridgeMap));
        System.out.println(String.join("", downBridgeMap));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStart() {
        System.out.println(TextType.START_MESSAGE.getText());
    }

    public void initMap(Bridge firstBridge, List<String> upBridgeMap, List<String> downBridgeMap) {
        upBridgeMap.add(TextType.BRIDGE_START.getText());
        downBridgeMap.add(TextType.BRIDGE_START.getText());

        makeMap(firstBridge, upBridgeMap, downBridgeMap);
    }

    public void makeBridgeToMap(List<Bridge> bridges, List<String> upBridgeMap,
            List<String> downBridgeMap) {

        for (int i = 1; i < bridges.size(); i++) {
            upBridgeMap.add(TextType.BRIDGE_MID.getText());
            downBridgeMap.add(TextType.BRIDGE_MID.getText());

            makeMap(bridges.get(i), upBridgeMap, downBridgeMap);
        }

        upBridgeMap.add(TextType.BRIDGE_END.getText());
        downBridgeMap.add(TextType.BRIDGE_END.getText());
    }

    public void makeMap(Bridge bridge, List<String> upBridgeMap, List<String> downBridgeMap) {
        if (bridge.equals(Bridge.UP_CORRECT) || bridge.equals(Bridge.DOWN_WRONG)) {
            upBridgeMap.add(TextType.POSSIBLE_SPACE.getText());
            downBridgeMap.add(TextType.IMPOSSIBLE_SPACE.getText());

        } else if (bridge.equals(Bridge.UP_WRONG) || bridge.equals(Bridge.DOWN_CORRECT)) {
            upBridgeMap.add(TextType.IMPOSSIBLE_SPACE.getText());
            downBridgeMap.add(TextType.POSSIBLE_SPACE.getText());
        }
    }
}
