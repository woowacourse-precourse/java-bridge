package bridge.domain.resources;

import bridge.domain.bridgebuilder.BridgeGame;
import java.util.List;

public class Bridge {

    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 20;

    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge of(int size) {
        validateBridgeSize(size);
        return new Bridge(buildBridge(size));
    }

    private static void validateBridgeSize(int size) {
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return bridge.size();
    }

    private static List<String> buildBridge(int size) {
        return BridgeGame.buildAnswerBridge(size);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
