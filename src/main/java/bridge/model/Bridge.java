package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridgeShape;
    private List<String> crossUpsideBridge = new ArrayList<>();
    private List<String> crossDownBridge = new ArrayList<>();

    public Bridge(List<String> bridgeShape) {
        this.bridgeShape = bridgeShape;
    }

    public String getShape(int position) {
        return bridgeShape.get(position);
    }

    public void setUpsideBridge(String bridgeRendering) {
        this.crossUpsideBridge.add(bridgeRendering);
    }

    public void setDownBridge(String bridgeRendering) {
        this.crossDownBridge.add(bridgeRendering);
    }

    public List<String> getUpsideBridge() {
        return crossUpsideBridge;
    }

    public List<String> getDownBridge() {
        return crossDownBridge;
    }

    public void clear() {
        this.crossUpsideBridge = new ArrayList<>();
        this.crossDownBridge = new ArrayList<>();
    }

    public int length() {
        return this.bridgeShape.size();
    }
}
