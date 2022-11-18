package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private StringBuilder leftLoggingResult = new StringBuilder("[");
    private StringBuilder rightLoggingResult = new StringBuilder("[");

    public List<String> move(String moving, List<String> bridge, int index) {
        return loggingGameResult(moving, bridge, index);
    }

    public boolean canMove(List<String> movingResult) {
        return !movingResult.get(0).contains("X") && !movingResult.get(1).contains("X");
    }

    public boolean isGameEnded(List<String> bridge, int index) {
        return index == bridge.size();
    }

    public boolean retry(String command) {
        return command.equals("R");
    }

    public boolean checkBridge(String userMoving, String targetBridge) {
        return userMoving.equals(targetBridge);
    }

    public void initializeLeftRightMovingLog() {
        this.leftLoggingResult = new StringBuilder("[");
        this.rightLoggingResult = new StringBuilder("[");
    }

    public List<String> loggingGameResult(String moving, List<String> bridge, int index) {
        leftBridgeSuccessFinalLogging(moving, bridge, index);
        rightBridgeSuccessFinalLogging(moving, bridge, index);
        leftBridgeSuccessLogging(moving, bridge, index);
        rightBridgeSuccessLogging(moving, bridge, index);
        leftBridgeFailLogging(moving, bridge, index);
        rightBridgeFailLogging(moving, bridge, index);
        List<String> result = new ArrayList<>();
        result.add(leftLoggingResult.toString());
        result.add(rightLoggingResult.toString());
        return result;
    }

    public void leftBridgeSuccessLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index < bridge.size() - 1) {
            leftLoggingResult.append(" O |");
            rightLoggingResult.append("   |");
        }
    }

    public void leftBridgeSuccessFinalLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index == bridge.size() - 1) {
            leftLoggingResult.append(" O ]");
            rightLoggingResult.append("   ]");
        }
    }

    public void rightBridgeSuccessLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index < bridge.size() - 1) {
            leftLoggingResult.append("   |");
            rightLoggingResult.append(" O |");
        }
    }

    public void rightBridgeSuccessFinalLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index == bridge.size() - 1) {
            leftLoggingResult.append("   ]");
            rightLoggingResult.append(" O ]");
        }
    }

    public void leftBridgeFailLogging(String moving, List<String> bridge, int index) {
        if (!checkBridge(moving, bridge.get(index)) && moving.equals("U")) {
            leftLoggingResult.append(" X ]");
            rightLoggingResult.append("   ]");
        }
    }

    public void rightBridgeFailLogging(String moving, List<String> bridge, int index) {
        if (!checkBridge(moving, bridge.get(index)) && moving.equals("D")) {
            leftLoggingResult.append("   ]");
            rightLoggingResult.append(" X ]");
        }
    }
}