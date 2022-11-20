package bridge.domain;

import static java.lang.Integer.*;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class Bridge {
    private final List<String> bridge;

    public Bridge(String size) {
        int bridgeSize = validateInteger(size);
        validateRange(bridgeSize);
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    public void setBridge(List<String> bridge) {
        this.bridge.addAll(bridge);
    }

    private int validateInteger(String size) {
        String regex = "^[0-9]+$";

        if (!size.matches(regex)) {
            throw new IllegalArgumentException();
        }

        return parseInt(size);
    }

    private void validateRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException();
        }
    }
}
