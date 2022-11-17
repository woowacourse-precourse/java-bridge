package bridge.domain;

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

    public void move(String input) {
        if (input.equals(bridge.get(positionOnBridge++))) {
            if (positionOnBridge == bridge.size()) {
                this.bridgeGameState = BridgeGameState.SUCCESS_AND_END;
                return;
            }
            this.bridgeGameState = BridgeGameState.NORMAL;
            return;
        }
        this.bridgeGameState = BridgeGameState.FAIL;
    }
}
