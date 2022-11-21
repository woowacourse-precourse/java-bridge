package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.exception.BridgeSizeException;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public List<String> getBridge() {
        return bridge;
    }

    public Bridge(String size) {
        validateSize(size);
        this.bridge = make(Integer.parseInt(size));
    }

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> make(int size) {
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    private int validateSize(String size) {
        BridgeSizeException.validate(size);
        return Integer.parseInt(size);
    }

    public boolean isRightMoving(int index, String moving) {
        return moving.equals(bridge.get(index));
    }

    public int getSize() {
        return bridge.size();
    }
}
