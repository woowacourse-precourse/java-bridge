package bridge.model;

import static bridge.exception.BridgeSizeException.validate;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public List<String> getBridge() {
        return bridge;
    }

    public Bridge(String size) {
        validate(size);
        this.bridge = make(Integer.parseInt(size));
    }

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> make(int size) {
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    public boolean isRightMoving(int index, String moving) {
        return moving.equals(bridge.get(index));
    }

    public int getSize() {
        return bridge.size();
    }
}
