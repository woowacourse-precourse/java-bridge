package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private StringBuilder leftResult = new StringBuilder("[");
    private StringBuilder rightResult = new StringBuilder("[");

    public List<String> move(String moving, List<String> bridge, int index) {
        return loggingGameResult(moving, bridge, index);
    }

    public boolean isGameDone(List<String> movingResult) {
        if (movingResult.get(0).contains("X") || movingResult.get(1).contains("X")) {
            return true;
        }
        return false;
    }

    public boolean retry(String command) {
        if (command.equals("R")) {
            return true;
        }
        return false;
    }

    public boolean checkBridge(String userMoving, String targetBridge) {
        if (userMoving.equals(targetBridge)) {
            return true;
        }
        return false;
    }

    public void initializeLeftRightResult() {
        this.leftResult = new StringBuilder("[");
        this.rightResult = new StringBuilder("[");
    }

    public List<String> loggingGameResult(String moving, List<String> bridge, int index) {
        leftBridgeSuccessFinalLogging(moving, bridge, index);
        rightBridgeSuccessFinalLogging(moving, bridge, index);
        leftBridgeSuccessLogging(moving, bridge, index);
        rightBridgeSuccessLogging(moving, bridge, index);
        leftBridgeFailLogging(moving, bridge, index);
        rightBridgeFailLogging(moving, bridge, index);
        List<String> result = new ArrayList<>();
        result.add(leftResult.toString());
        result.add(rightResult.toString());
        return result;
    }

    public void leftBridgeSuccessLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index < bridge.size() - 1) {
            leftResult.append(" O |");
            rightResult.append("   |");
        }
    }

    public void leftBridgeSuccessFinalLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index == bridge.size() - 1) {
            leftResult.append(" O ]");
            rightResult.append("   ]");
        }
    }

    public void rightBridgeSuccessLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index < bridge.size() - 1) {
            leftResult.append("   |");
            rightResult.append(" O |");
        }
    }

    public void rightBridgeSuccessFinalLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index == bridge.size() - 1) {
            leftResult.append("   ]");
            rightResult.append(" O ]");
        }
    }

    public void leftBridgeFailLogging(String moving, List<String> bridge, int index) {
        if (!checkBridge(moving, bridge.get(index)) && moving.equals("U")) {
            leftResult.append(" X ]");
            rightResult.append("   ]");
        }
    }

    public void rightBridgeFailLogging(String moving, List<String> bridge, int index) {
        if (!checkBridge(moving, bridge.get(index)) && moving.equals("D")) {
            leftResult.append("   ]");
            rightResult.append(" X ]");
        }
    }
}