package bridge.view;

import bridge.type.Bridge;
import bridge.type.Result;
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
    public void printResult(List<Bridge> bridges, Result result, int tryCount) {
        System.out.println(TextType.RESULT_MESSAGE.getText());

        printMap(bridges);

        System.out.println(TextType.RESULT_STATUS_MESSAGE.getText() + result.getResult());
        System.out.println(TextType.TRY_COUNT_MESSAGE.getText() + tryCount);
    }

    public void printStart() {
        System.out.println(TextType.START_MESSAGE.getText());
    }

    public void printRestart() {
        System.out.println(TextType.RETRY_MESSAGE.getText());
    }

    public void printMove() {
        System.out.println(TextType.MOVE_MESSAGE.getText());
    }

    public void printSize() {
        System.out.println(TextType.SIZE_MESSAGE.getText());
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
        if (bridge.equals(Bridge.UP_CORRECT)) {
            upBridgeMap.add(TextType.POSSIBLE_SPACE.getText());
            downBridgeMap.add(" ");

        } else if (bridge.equals(Bridge.UP_WRONG)) {
            upBridgeMap.add(TextType.IMPOSSIBLE_SPACE.getText());
            downBridgeMap.add(" ");
        } else if (bridge.equals(Bridge.DOWN_WRONG)) {
            upBridgeMap.add(" ");
            downBridgeMap.add(TextType.IMPOSSIBLE_SPACE.getText());
        } else if (bridge.equals(Bridge.DOWN_CORRECT)) {
            upBridgeMap.add(" ");
            downBridgeMap.add(TextType.POSSIBLE_SPACE.getText());
        }
    }
}
