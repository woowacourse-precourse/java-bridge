package bridge.domain.bridgeadd;

class DownBridgeMessageAddStrategy implements BridgeMessageAddStrategy {
    public void addMessage(String message, BridgeMessageAdder bridgeMessageAdder) {
        bridgeMessageAdder.upBridge.add(EMPTY_MESSAGE);
        bridgeMessageAdder.downBridge.add(message);
    }
}
