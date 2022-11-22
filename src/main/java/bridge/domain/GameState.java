package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private final List<String> moves = new ArrayList<>();
    private BridgeState bridgeState = BridgeState.CROSSING;
    private int attempt = 0;

    public GameState updateState(String move, BridgeState bridgeState) {
        moves.add(move);
        this.bridgeState = bridgeState;

        return this;
    }

    public void init() {
        moves.clear();
        bridgeState = BridgeState.CROSSING;
        attempt++;
    }

    public int nextLocation() {
        return moves.size();
    }

    public boolean isFall() {
        return bridgeState.equals(BridgeState.FALL);
    }

    public boolean isCrossed() {
        return bridgeState.equals(BridgeState.CROSSED);
    }

    public boolean isCrossing() {
        return bridgeState.equals(BridgeState.CROSSING);
    }

    public List<String> getMoves() {
        return moves;
    }

    public int getAttempt() {
        return attempt;
    }
}
