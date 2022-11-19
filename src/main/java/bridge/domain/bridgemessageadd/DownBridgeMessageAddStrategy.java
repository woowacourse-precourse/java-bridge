package bridge.domain.bridgemessageadd;

class DownBridgeMessageAddStrategy implements BridgeMessageAddStrategy {
    public void addMessage(final String message, final BridgeMessageAdder bridgeMessageAdder) {
        bridgeMessageAdder.upBridge.add(EMPTY_MESSAGE);
        bridgeMessageAdder.downBridge.add(message);
    }
}
