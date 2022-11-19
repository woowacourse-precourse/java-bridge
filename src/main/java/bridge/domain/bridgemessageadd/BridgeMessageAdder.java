package bridge.domain.bridgemessageadd;

import static bridge.domain.bridgemessageadd.BridgeMessageAdderConverter.bridgeAddStrategyConverter;
import static bridge.domain.bridgemessageadd.BridgeMessageAdderConverter.saveMessageConverter;
import static bridge.domain.bridgemessageadd.BridgeMessageAdderConverter.setConverter;

import java.util.List;

public class BridgeMessageAdder {
    protected final List<String> upBridge;
    protected final List<String> downBridge;

    public BridgeMessageAdder(final List<String> upBridge, final List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
        setConverter();
    }

    private BridgeMessageAddStrategy choiceStrategy(final String inputPosition) {
        return bridgeAddStrategyConverter.get(inputPosition);
    }

    public void addBridgeMessage(final String inputPosition, final boolean moveResult) {
        BridgeMessageAddStrategy bridgeMessageAddStrategy = choiceStrategy(inputPosition);
        bridgeMessageAddStrategy.addMessage(saveMessageConverter.get(moveResult), this);
    }
}
