package bridge;

import java.util.List;

public class BridgeGame {
    public static final String CMD_UP = "U";
    public static final String CMD_DOWN = "D";
    public static final String CMD_RETRY = "R";
    public static final String CMD_QUIT = "Q";

    private List<String> bridge;
    private int tryCount;
    private int lastPosition;
    private String lastCommand;

    public BridgeGame() {
        lastPosition = 0;
        bridge = null;
        tryCount = 1;
        lastCommand = null;
    }

    public void move(String command) {
        lastPosition += 1;
        lastCommand = command;
    }

    public void retry() {
        lastPosition = 0;
        tryCount++;
    }

    public boolean isPlayerAlive() {
        if (getLastPosition() == 0 || bridge.get(getLastIndex()).equals(lastCommand)) {
            return true;
        }
        return false;
    }

    public boolean isSuccess() {
        if (bridge.size() == getLastPosition() && bridge.get(getLastIndex()).equals(lastCommand)) {
            return true;
        }
        return false;
    }

    public String getGameResultToString() {
        if (isSuccess()) {
            return "성공";
        }
        return "실패";
    }

    public void initBridge(List<String> bridgeMap) {
        bridge = bridgeMap;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getBridgeCell(int i) {
        return bridge.get(i);
    }

    public int getLastPosition() {
        return lastPosition;
    }

    public int getLastIndex() {
        return lastPosition - 1;
    }

    public String getLastCommand() {
        return lastCommand;
    }
}
