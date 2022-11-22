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

    public Integer currentSize() {
        return currentState.size();
    }

    public Integer bridgeSize() {
        return finalState.size();
    }

    public void move(BridgePosition moving) {
        currentState.add(moving.getPosition());
    }

    public void clearCurrent() {
        currentState.clear();
    }

    public String getCurrentAt(int index) {
        return currentState.get(index);
    }

    public boolean getMatched(int index) {
        return currentState.get(index).equals(finalState.get(index));
    }
}
