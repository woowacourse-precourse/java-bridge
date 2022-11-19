package bridge.domain.bridgemessageadd;

class UpBridgeMessageAddStrategy implements BridgeMessageAddStrategy {
    public void addMessage(final String message, final BridgeMessageAdder bridgeMessageAdder) {
        bridgeMessageAdder.upBridge.add(message);
        bridgeMessageAdder.downBridge.add(EMPTY_MESSAGE);
    }
}
