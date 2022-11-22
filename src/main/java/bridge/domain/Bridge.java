package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.BridgeConstants;
import bridge.constant.ExceptionConstants;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(String size) {
        int parsedSize = parse(size);
        isCorrectRange(parsedSize);
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(parsedSize);
    }

    private int parse(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_RANGE.getMessage());
        }
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
}
