package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameRound {
    private static final String MOVING_COMMAND_UP = "U";
    private static final String MOVING_COMMAND_DOWN = "D";
    private static final String BLANK = " ";

    private List<List<String>> playedBridge;
    private int bridgeIndex;
    private boolean isWin;

    public GameRound() {
        playedBridge = new ArrayList<>();
        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();
        playedBridge.add(upperBridge);
        playedBridge.add(lowerBridge);

        bridgeIndex = 0;
        isWin = false;
    }

    public List<List<String>> getPlayedBridge() {
        return playedBridge;
    }

    public int getBridgeIndex() {
        return bridgeIndex;
    }

    public void setBridgeIndex(int bridgeIndex) {
        this.bridgeIndex = bridgeIndex;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public void recordResult(String movingCommand, String bridgeLocation) {
        if(movingCommand.equals(MOVING_COMMAND_UP)) {
            playedBridge.get(0).add(bridgeLocation);
            playedBridge.get(1).add(BLANK);
            return;
        }
        playedBridge.get(1).add(bridgeLocation);
        playedBridge.get(0).add(BLANK);
    }
}
