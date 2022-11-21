package bridge.domain.bridgemessageadd;

import static bridge.Constants.FAIL_MESSAGE;
import static bridge.Constants.PASS_MESSAGE;
import static bridge.domain.bridgemessageadd.BridgeMessageAdderConverter.bridgeAddStrategyConverter;

import java.util.List;

public class BridgeMessageAdder {
    protected final List<String> upBridge;
    protected final List<String> downBridge;

    public BridgeMessageAdder(final List<String> upBridge, final List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
        BridgeMessageAdderConverter.setConverter();
    }

    private BridgeMessageAddStrategy choiceStrategy(final String inputPosition) {
        return bridgeAddStrategyConverter.get(inputPosition);
    }

    public void addPassBridgeMessage(final String inputPosition) {
        BridgeMessageAddStrategy bridgeMessageAddStrategy = choiceStrategy(inputPosition);
        bridgeMessageAddStrategy.addMessage(PASS_MESSAGE, this);
    }

    public void addFailBridgeMessage(final String inputPosition) {
        BridgeMessageAddStrategy bridgeMessageAddStrategy = choiceStrategy(inputPosition);
        bridgeMessageAddStrategy.addMessage(FAIL_MESSAGE, this);
    }
}
