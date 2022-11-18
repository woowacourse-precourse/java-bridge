package bridge.domain.bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public class BridgeMap {
    private final List<BridgeDirection> bridgeDirections;

    private BridgeMap(List<BridgeDirection> bridgeDirections) {
        this.bridgeDirections = bridgeDirections;
    }

    public static BridgeMap from(List<String> bridge) {
        List<BridgeDirection> bridgeDirections = bridge.stream()
                .map(BridgeDirection::fromSignature)
                .collect(Collectors.toUnmodifiableList());

        return new BridgeMap(bridgeDirections);
    }

    public int size() {
        return this.bridgeDirections.size();
    }

    public List<BridgeDirection> getBridgeDirections() {
        return bridgeDirections;
    }
}
