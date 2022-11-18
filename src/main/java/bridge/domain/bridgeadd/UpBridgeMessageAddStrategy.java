package bridge.domain.bridgeadd;

class UpBridgeMessageAddStrategy implements BridgeMessageAddStrategy {
    public void addMessage(String message, BridgeMessageAdder bridgeMessageAdder) {
        bridgeMessageAdder.upBridge.add(message);
        bridgeMessageAdder.downBridge.add(EMPTY_MESSAGE);
    }
}
