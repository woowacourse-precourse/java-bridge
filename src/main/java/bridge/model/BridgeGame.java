package bridge.model;

import java.util.ArrayList;
import java.util.List;

enum GameState {
    Over,
    Playing,
    Done
}

public class BridgeGame {
    private BridgeMaker bridgeMaker;
    private List<String> bridge;
    private List<String> bridgeState;
    private String userState;
    private int moveTime;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> move(String move) {
        moveTime++;
        if (!checkMove(move)) {
            userState = String.valueOf(GameState.Over);
            move = move + "X";
        } else if (moveTime == bridge.size()) {
            userState = String.valueOf(GameState.Done);
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
        bridge = bridgeMaker.makeBridge(size);
        userState = String.valueOf(GameState.Playing);
        bridgeState = new ArrayList<String>();
        System.out.println(bridge);
    }

    public String getUserState() {
        return userState;
    }
    public void retry() {
    }
}
