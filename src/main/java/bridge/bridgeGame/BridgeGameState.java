package bridge.bridgeGame;

import bridge.bridge.Bridge;
import bridge.bridge.BridgePosition;
import java.util.List;

public class BridgeGameState {

    private final Bridge currentState = new Bridge();

    private final Bridge finalState;

    public BridgeGameState(List<String> finalState) {
        this.finalState = new Bridge(finalState);
    }

    public void move(BridgePosition moving) {
        currentState.add(moving.getPosition());
    }
}
