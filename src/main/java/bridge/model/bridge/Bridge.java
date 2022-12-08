package bridge.model.bridge;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<BridgeDirection> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = toBridgeSign(bridge);
    }

    public static Bridge from(List<String> bridge) {
        return new Bridge(bridge);
    }

    public BridgeDirection getBridgeDirection(int index) {
        return bridge.get(index);
    }

    private List<BridgeDirection> toBridgeSign(List<String> bridge) {
        return bridge.stream().map(BridgeDirection::from).collect(Collectors.toList());
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public boolean isEndOfBridge(int index) {
        return index == bridge.size() - 1;
    }

}
