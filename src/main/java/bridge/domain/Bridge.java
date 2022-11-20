package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.BridgeConstants;
import bridge.constant.ExceptionConstants;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(int size) {
        isCorrectRange(size);
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    private void isCorrectRange(int size) {
        if (size < BridgeConstants.MINIMUM_LENGTH || BridgeConstants.MAXIMUM_LENGTH < size) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_RANGE.getMessage());
        }
    }

    public String get(int index) {
        return bridge.get(index);
    }

    public int size() {
        return bridge.size();
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }
}
