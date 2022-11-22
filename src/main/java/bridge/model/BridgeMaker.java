package bridge.model;

import bridge.model.constants.Command;
import bridge.model.enumeration.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateNumberRange(size);

        List<String> bridges = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridges.add(addBridge());
        }
        return bridges;
    }

    private String addBridge() {
        if (bridgeNumberGenerator.generate() == 1) {
            return Command.UP;
        }
        return Command.DOWN;
    }

    private void validateNumberRange(int size) {
        if (size < Command.INPUT_NUMBER_RANGE_START || size > Command.INPUT_NUMBER_RANGE_LAST) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getExceptionMessage());
        }
    }
}
