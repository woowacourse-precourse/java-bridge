package bridge;

public class BridgeBroker {
    BridgeMaker bridgeMaker;
    BridgeBroker() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }
    BridgeBroker(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void makeBridge() {
    }

    private void reqeustBridge() {
    }

    private void packageBridge() {
    }
}
