package bridge;

import bridge.constant.BridgeGameStstus;
import bridge.constant.BridgeMoveCommand;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_PASS = "O";
    private static final String BRIDGE_FAIL = "X";

    private List<String> upperBridge;
    private List<String> lowerBridge;

    private String upperBridgeView;
    private String lowerBridgeView;

    public OutputView() {

    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 다리 길이, 현재 step, 게임 상태 정보를 받아 사용자에게 출력
     */
    public void printMap(List<String> bridge, int step, BridgeGameStstus status) {
        initBridgeMap();
        for (int i = 0; i < step - 1; i++) {
            parseDirection(bridge.get(i));
        }
        parseLastDirection(bridge.get(step - 1), status);
        completeBridgeMap();
        System.out.println(upperBridgeView);
        System.out.println(lowerBridgeView);
    }

    private void initBridgeMap() {
        upperBridge.clear();
        lowerBridge.clear();
        upperBridge.add("[");
        lowerBridge.add("[");
    }

    private void parseDirection(String dir) {
        if (dir.equals(BridgeMoveCommand.MOVE_UP.command)) {
            upperBridge.add(BRIDGE_PASS);
            return;
        }
        lowerBridge.add(BRIDGE_PASS);
    }

    private void parseLastDirection(String dir, BridgeGameStstus status) {
        String passOrFail = BRIDGE_PASS;
        if (status == BridgeGameStstus.FAIL) {
            passOrFail = BRIDGE_FAIL;
        }
        if (dir.equals(BridgeMoveCommand.MOVE_UP.command)) {
            upperBridge.add(passOrFail);
            return;
        }
        lowerBridge.add(passOrFail);
    }

    private void completeBridgeMap() {
        upperBridge.add("]");
        lowerBridge.add("]");

        upperBridgeView = String.join(" ", upperBridge);
        lowerBridgeView = String.join(" ", lowerBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
