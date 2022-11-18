package bridge.domain.bridgeadd;

import static bridge.domain.bridgeadd.BridgeMessageAdderConverter.bridgeAddStrategyConverter;
import static bridge.domain.bridgeadd.BridgeMessageAdderConverter.saveMessageConverter;
import static bridge.domain.bridgeadd.BridgeMessageAdderConverter.setConverter;

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

    public void addBridgeMessage(String inputPosition, boolean result) {
        BridgeMessageAddStrategy bridgeMessageAddStrategy = choiceStrategy(inputPosition);
        bridgeMessageAddStrategy.addMessage(saveMessageConverter.get(result), this);
    }
}
