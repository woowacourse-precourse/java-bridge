package bridge.domain;

import bridge.BridgeShape;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int size() {
        return bridge.size();
    }

    public Bridge getUpBridge() {
        return createErasedShapeBridge(BridgeShape.DOWN.getShape());
    }

    public Bridge getDownBridge() {
        return createErasedShapeBridge(BridgeShape.UP.getShape());
    }

    public String getBridgeShapeByPosition(int position) {
        return bridge.get(position);
    }

    private Bridge createErasedShapeBridge(String shapeToErase) {
        List<String> removedBridge = new ArrayList<>(bridge);
        removedBridge.replaceAll(bridgeShape -> bridgeShape.replace(shapeToErase, " "));
        return new Bridge(removedBridge);
    }
}
