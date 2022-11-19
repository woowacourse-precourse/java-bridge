package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BridgeShape {

    private final String UP_BRIDGE = "U";
    private final String DOWN_BRIDGE = "D";
    private final String OPEN = "[";
    private final String CLOSE = "]";
    private final String CONNECT = "|";
    private final String PASS_STEP = " O ";
    private final String FAIL_STEP = " X ";
    private final String EMPTY_STEP = "   ";
    private final List<String> upBridgeShape = new ArrayList<>();
    private final List<String> downBridgeShape = new ArrayList<>();

    public void moveBridge(String whereBridge, boolean checkBridge) {

        moveNextStep(whereBridge, checkBridge);
    }

    private void moveNextStep(String whereBridge, boolean checkBridge) {
        if (Objects.equals(whereBridge, UP_BRIDGE)) {
            moveUpBridge(checkBridge);
            notMoveDownBridge();
        }
        if (Objects.equals(whereBridge, DOWN_BRIDGE)) {
            moveDownBridge(checkBridge);
            notMoveUpBridge();
        }
    }

    private void moveUpBridge(boolean checkBridge) {
        if (checkBridge) {
            upBridgeShape.add(PASS_STEP);
        }
        if (!checkBridge) {
            upBridgeShape.add(FAIL_STEP);
        }
    }

    private void moveDownBridge(boolean checkBridge) {
        if (checkBridge) {
            downBridgeShape.add(PASS_STEP);
        }
        if (!checkBridge) {
            downBridgeShape.add(FAIL_STEP);
        }
    }

    private void notMoveUpBridge() {
        upBridgeShape.add(EMPTY_STEP);
    }

    private void notMoveDownBridge() {
        downBridgeShape.add(EMPTY_STEP);
    }

    public void initializeBridgeShape() {
        upBridgeShape.clear();
        downBridgeShape.clear();
    }

    public StringBuilder getUpBridge() {
        return printBridge(upBridgeShape);
    }

    public StringBuilder getDownBridge() {
        return printBridge(downBridgeShape);
    }

    private StringBuilder printBridge(List<String> bridgeShape) {
        StringBuilder bridge = new StringBuilder();

        return bridge.append(OPEN)
                .append(getCONNECT(bridgeShape))
                .append(CLOSE);
    }

    private String getCONNECT(List<String> bridgeShape) {
        return String.join(CONNECT, bridgeShape);
    }
}
