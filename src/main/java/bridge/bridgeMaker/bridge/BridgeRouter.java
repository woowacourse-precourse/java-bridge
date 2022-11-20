package bridge.bridgeMaker.bridge;

import bridge.bridgeMaker.exception.NotFoundBridgeException;
import java.util.Arrays;
import java.util.List;

public class BridgeRouter {
    private static List<Bridge> bridges = Arrays.asList(new DownBridge(), new UpBridge());

    private BridgeRouter() {
    }

    public static Bridge getMatchBridge(int value) {
        return bridges.stream()
                .filter(bridge -> bridge.isSame(value))
                .findAny()
                .orElseThrow(NotFoundBridgeException::new);
    }

    public static Bridge getMatchBridge(String direction) {
        return bridges.stream()
                .filter(bridge -> bridge.getDirection().equals(direction))
                .findAny()
                .orElseThrow(NotFoundBridgeException::new);
    }
}
