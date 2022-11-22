package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.Errors;
import bridge.util.Rules;
import bridge.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Plate> bridge;

    public Bridge(int bridgeLength) {
        Validator.validateBridgeSize(bridgeLength);
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> makeBridge = bridgeMaker.makeBridge(bridgeLength);
        bridge = bridgeStringToPlate(makeBridge);
    }

    private List<Plate> bridgeStringToPlate(List<String> bridge) {
        List<Plate> newBridge = new ArrayList<>();
        for (String symbol : bridge) {
            newBridge.add(Plate.findBySymbol(symbol));
        }
        return newBridge;
    }

    public boolean possibleNextStep(int nextBridgeIndex, Plate nextPlate) {
        Plate bridgePlate = bridge.get(nextBridgeIndex);
        return nextPlate.equals(bridgePlate);
    }

    public boolean sameAs(List<Plate> otherBridge) {
        return bridge.equals(otherBridge);
    }
}
