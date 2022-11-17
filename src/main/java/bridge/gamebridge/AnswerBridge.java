package bridge.gamebridge;

import bridge.domain.Bridge;

public class AnswerBridge {

    private final Bridge bridge;

    public AnswerBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public boolean checkBridge(Bridge otherBridge) {
        return this.bridge.isPassableBridge(otherBridge);
    }
}
