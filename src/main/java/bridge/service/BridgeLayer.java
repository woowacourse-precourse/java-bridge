package bridge.service;

public enum BridgeLayer {
    LOWER_LAYER(0),
    UPPER_LAYER(1);

    private final int layer;

    BridgeLayer(int layer) {
        this.layer = layer;
    }

    public int getLayer() {
        return layer;
    }
}
