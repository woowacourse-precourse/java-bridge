package bridge.domain.bridgeadd;

public interface BridgeMessageAddStrategy {
    String EMPTY_MESSAGE = "   ";

    void addMessage(String mes, BridgeMessageAdder bridgeMessageAdder);
}