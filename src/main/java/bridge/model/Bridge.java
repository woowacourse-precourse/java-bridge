package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.Errors;
import bridge.util.Rules;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Plate> bridge;

    public Bridge() {
        bridge = new ArrayList<>();
    }

    public Bridge(int bridgeLength) {
        validateLength(bridgeLength);
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> makeBridge = bridgeMaker.makeBridge(bridgeLength);
        this.bridge = bridgeStringToPlate(makeBridge);
    }

    private List<Plate> bridgeStringToPlate(List<String> bridge) {
        List<Plate> newBridge = new ArrayList<>();
        for (String symbol : bridge) {
            newBridge.add(Plate.findBySymbol(symbol));
        }
        return newBridge;
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

    public boolean possibleNextStep(int nextBridgeIndex, Plate nextPlate) {
        Plate bridgePlate = this.bridge.get(nextBridgeIndex);
        return nextPlate.equals(bridgePlate);
    }

    public int getBridgeLastIndex() {
        return bridge.size() - 1;
    }

    public boolean sameAs(List<Plate> otherBridge) {
        return bridge.equals(otherBridge);
    }
}
