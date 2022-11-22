package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Tile> bridge;

    public Bridge(int bridgeLength) {
        Validator.validateBridgeSize(bridgeLength);
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> makeBridge = bridgeMaker.makeBridge(bridgeLength);
        bridge = bridgeStringToTile(makeBridge);
    }

    private List<Tile> bridgeStringToTile(List<String> bridge) {
        List<Tile> newBridge = new ArrayList<>();
        for (String symbol : bridge) {
            newBridge.add(Tile.findBySymbol(symbol));
        }
        return newBridge;
    }

    public boolean possibleNextStep(int nextBridgeIndex, Tile nextTile) {
        Tile bridgeTile = bridge.get(nextBridgeIndex);
        return nextTile.equals(bridgeTile);
    }

    public boolean sameAs(List<Tile> otherBridge) {
        return bridge.equals(otherBridge);
    }
}
