package bridge.model;

import java.util.ArrayList;
import java.util.List;

enum GameState {
    Over,
    Playing,
    Success
}

public class BridgeGame {
    private BridgeMaker bridgeMaker;
    private List<String> bridge;
    private List<String> bridgeState;
    private String userState;
    private int moveTime;
    private int tryTime;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> move(String move) {
        moveTime++;
        if (!checkMove(move)) {
            userState = String.valueOf(GameState.Over);
            move = move + "X";
        } else if (moveTime == bridge.size()) {
            userState = String.valueOf(GameState.Success);
        }
        bridgeState.add(move);
        return bridgeState;
    }

    private boolean checkMove(String move) {
        if (move.equals(bridge.get(moveTime - 1))) {
            return true;
        }
        return false;
    }

    public void setBridge(int size) {
        moveTime = 0;
        tryTime = 1;
        bridge = bridgeMaker.makeBridge(size);
        userState = String.valueOf(GameState.Playing);
        bridgeState = new ArrayList<String>();
    }

    public String getUserState() {
        return userState;
    }

    public void retry() {
        tryTime++;
        moveTime = 0;
        userState = String.valueOf(GameState.Playing);
        bridgeState = new ArrayList<String>();
    }

    public List<String> getBridgeState() {
        return bridgeState;
    }

    public int getTryTime() {
        return tryTime;
    }
}
