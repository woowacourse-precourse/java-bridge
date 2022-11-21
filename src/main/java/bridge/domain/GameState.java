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
}
