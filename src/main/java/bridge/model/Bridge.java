package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.Errors;
import bridge.util.Rules;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(int bridgeLength) {
        validateLength(bridgeLength);
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> makeBridge = bridgeMaker.makeBridge(bridgeLength);
        this.bridge = makeBridge;
    }

    private void validateLength(int bridgeLength) {
        if(isOutOfBoundsLength(bridgeLength)) {
            throw new IllegalArgumentException(Errors.ERROR_BRIDGE_LENGTH.getMessage());
        }
    }

    private boolean isOutOfBoundsLength(int bridgeLength) {
        return (bridgeLength < Rules.BRIDGE_MIN_LENGTH)
                || (bridgeLength > Rules.BRIDGE_MAX_LENGTH);
    }

    public boolean possibleNextStep() {
        return false;
    }
}
