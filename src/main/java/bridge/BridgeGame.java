package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private StringBuilder upMovingLoggingResult = new StringBuilder("[");
    private StringBuilder downMovingLoggingResult = new StringBuilder("[");

    public List<String> loggingGameResult(String moving, List<String> bridge, int index) {
        upBridgeSuccessFinalLogging(moving, bridge, index);
        downBridgeSuccessFinalLogging(moving, bridge, index);
        upBridgeSuccessLogging(moving, bridge, index);
        downBridgeSuccessLogging(moving, bridge, index);
        upBridgeFailLogging(moving, bridge, index);
        downBridgeFailLogging(moving, bridge, index);
        List<String> result = new ArrayList<>();
        result.add(upMovingLoggingResult.toString());
        result.add(downMovingLoggingResult.toString());
        return result;
    }

    private boolean checkBridge(String userMoving, String targetBridge) {
        return userMoving.equals(targetBridge);
    }

    private void upBridgeSuccessLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index < bridge.size() - 1) {
            upMovingLoggingResult.append(" O |");
            downMovingLoggingResult.append("   |");
        }
    }

    private void upBridgeSuccessFinalLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index == bridge.size() - 1) {
            upMovingLoggingResult.append(" O ]");
            downMovingLoggingResult.append("   ]");
        }
    }

    private void downBridgeSuccessLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index < bridge.size() - 1) {
            upMovingLoggingResult.append("   |");
            downMovingLoggingResult.append(" O |");
        }
    }

    private void downBridgeSuccessFinalLogging(String moving, List<String> bridge, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index == bridge.size() - 1) {
            upMovingLoggingResult.append("   ]");
            downMovingLoggingResult.append(" O ]");
        }
    }

    private void upBridgeFailLogging(String moving, List<String> bridge, int index) {
        if (!checkBridge(moving, bridge.get(index)) && moving.equals("U")) {
            upMovingLoggingResult.append(" X ]");
            downMovingLoggingResult.append("   ]");
        }
    }

    private void downBridgeFailLogging(String moving, List<String> bridge, int index) {
        if (!checkBridge(moving, bridge.get(index)) && moving.equals("D")) {
            upMovingLoggingResult.append("   ]");
            downMovingLoggingResult.append(" X ]");
        }
    }

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

    public void initializeLeftRightMovingLog() {
        this.upMovingLoggingResult = new StringBuilder("[");
        this.downMovingLoggingResult = new StringBuilder("[");
    }
}