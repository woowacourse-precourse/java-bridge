package bridge.domain;

import bridge.state.BridgeGameState;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private BridgeGameState bridgeGameState;
    private int positionOnBridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeGameState = BridgeGameState.NORMAL;
        this.positionOnBridge = 0;
    }

    public BridgeGameState getBridgeGameState() {
        return bridgeGameState;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getPositionOnBridge() {
        return positionOnBridge;
    }

    public BridgeGameState move(String input) {
        if (input.equals(bridge.get(positionOnBridge++))) {
            if (positionOnBridge == bridge.size()) {
                return this.bridgeGameState = BridgeGameState.SUCCESS_AND_END;
            }
            return this.bridgeGameState = BridgeGameState.NORMAL;
        }
        return this.bridgeGameState = BridgeGameState.FAIL;
    }

    public void init() {
        positionOnBridge = 0;
    }

    public String toString() {
        return BridgeOutputView.bridgePrint(this);
    }
}
