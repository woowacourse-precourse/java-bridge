package bridge;

import java.util.List;

public class BridgeGame {
    public static final String CMD_UP = "U";
    public static final String CMD_DOWN = "D";
    public static final String CMD_RETRY = "R";
    public static final String CMD_QUIT = "Q";

    private List<String> bridge;
    private int tryCount;
    private int position;
    private String lastCommand;

    public BridgeGame() {
        position = 0;
        bridge = null;
        tryCount = 1;
        lastCommand = null;
    }

    public void move(String command) {
        position += 1;
        lastCommand = command;
    }

    public void retry() {
        position = 0;
        tryCount++;
    }

    public boolean isPlayerAlive() {
        if (getPosition() == 0 || bridge.get(getIndex()).equals(lastCommand)) {
            return true;
        }
        return false;
    }

    public boolean isSuccess() {
        if (bridge.size() == getPosition() && bridge.get(getIndex()).equals(lastCommand)) {
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

    public int getPosition() {
        return position;
    }

    public int getIndex() {
        return position - 1;
    }

    public String getLastCommand() {
        return lastCommand;
    }
}
