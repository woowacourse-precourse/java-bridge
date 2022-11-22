package bridge.domain.bridgemessageadd;

public interface BridgeMessageAddStrategy {
    String EMPTY_MESSAGE = "   ";

    void addMessage(String mes, BridgeMessageAdder bridgeMessageAdder);
}