package bridge;

import java.util.Collections;

public class BridgeAnswer {
    private final Bridge bridgeAnswer;

    public BridgeAnswer() {
        this.bridgeAnswer = new Bridge(Collections.emptyList());
    }

    public BridgeAnswer(Bridge bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
    }

    public BridgeAnswer makeBridgeAnswer(int size) {
        return new BridgeAnswer(new Bridge(new BridgeMaker().makeBridge(size)));
    }

    public Bridge getBridgeAnswer() {
        return bridgeAnswer;
    }
}
