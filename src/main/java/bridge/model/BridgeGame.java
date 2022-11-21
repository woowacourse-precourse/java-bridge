package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private BridgeMaker bridgeMaker;
    private List<String> bridge;
    private List<String> bridgeState;
    private String userState;
    private int tryTime;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> move(String move) {
        if (!checkMove(move)) {
            userState = GameState.Over.getState();
            move = move + "X";
        } else if (bridgeState.size() + 1 == bridge.size()) {
            userState = GameState.Success.getState();
        }
        bridgeState.add(move);
        return bridgeState;
    }

    private boolean checkMove(String move) {
        if (move.equals(bridge.get(bridgeState.size()))) {
            return true;
        }
        return false;
    }

    public void setBridge(int size) {
        tryTime = 1;
        bridge = bridgeMaker.makeBridge(size);
        userState = GameState.Playing.getState();
        bridgeState = new ArrayList<String>();
    }

    public void retry() {
        tryTime++;
        userState = GameState.Playing.getState();
        bridgeState = new ArrayList<String>();
    }

    public String getUserState() {
        return userState;
    }

    public List<String> getBridgeState() {
        return bridgeState;
    }

    public int getTryTime() {
        return tryTime;
    }
}
