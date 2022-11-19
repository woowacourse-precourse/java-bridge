package bridge.domain.bridgemessageadd;

import static bridge.domain.bridgemessageadd.BridgeMessageAdderConverter.bridgeAddStrategyConverter;
import static bridge.domain.bridgemessageadd.BridgeMessageAdderConverter.saveMessageConverter;
import static bridge.domain.bridgemessageadd.BridgeMessageAdderConverter.setConverter;

import java.util.List;

public class BridgeMessageAdder {
    protected final List<String> upBridge;
    protected final List<String> downBridge;

    public BridgeMessageAdder(List<String> upBridge, List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
        setConverter();
    }

    private BridgeMessageAddStrategy choiceStrategy(String inputPosition) {
        return bridgeAddStrategyConverter.get(inputPosition);
    }

    public void addBridgeMessage(String inputPosition, boolean moveResult) {
        BridgeMessageAddStrategy bridgeMessageAddStrategy = choiceStrategy(inputPosition);
        bridgeMessageAddStrategy.addMessage(saveMessageConverter.get(moveResult), this);
    }
}
