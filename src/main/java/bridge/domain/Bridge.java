package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Constants;
import java.util.List;

public class Bridge {
    private static final BridgeMaker BRIDGE_MAKER = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = List.copyOf(bridge);
    }

    private void validate(List<String> bridge) {
        isValidSize(bridge);
        isValidElement(bridge);
    }

    private void isValidSize(List<String> bridge) {
        if (bridge.size() < Constants.BRIDGE_SIZE_MIN || bridge.size() > Constants.BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidElement(List<String> bridge) {
        if (bridge.stream().noneMatch(s -> s.equals(Constants.CODE_UP) || s.equals(Constants.CODE_DOWN))) {
            throw new IllegalArgumentException();
        }
    }

    public static Bridge generateBridge(int bridgeSize) {
        return new Bridge(BRIDGE_MAKER.makeBridge(bridgeSize));
    }

    public boolean isMovable(String move, int location) {
        return bridge.get(location).equals(move);
    }

    public int size() {
        return bridge.size();
    }
}
