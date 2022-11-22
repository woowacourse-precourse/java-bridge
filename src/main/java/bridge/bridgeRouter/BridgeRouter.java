package bridge.bridgeRouter;

import bridge.bridgeRouter.bridge.Bridge;
import bridge.bridgeRouter.bridge.DownBridge;
import bridge.bridgeRouter.bridge.UpBridge;
import bridge.bridgeRouter.exception.NotFoundBridgeException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class BridgeRouter {
    private static List<Bridge> bridges = Arrays.asList(new DownBridge(), new UpBridge());

    private BridgeRouter() {
    }

    public static Bridge getMatchBridge(int value) {
        return getMatchBridge(bridge -> bridge.isSame(value));
    }

    public static Bridge getMatchBridge(String direction) {
        return getMatchBridge(bridge -> bridge.getDirection().equals(direction));
    }

    private static Bridge getMatchBridge(Predicate<Bridge> filter) {
        return bridges.stream()
                .filter(bridge -> filter.test(bridge))
                .findAny()
                .orElseThrow(NotFoundBridgeException::new);
    }
}
