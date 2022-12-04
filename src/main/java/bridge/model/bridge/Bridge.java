package bridge.model.bridge;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge from(List<String> bridge) {
        return new Bridge(bridge);
    }

    public Iterator<BridgeDirection> getBridgeIterator() {
        return toBridgeSign(bridge).listIterator();
    }
    public BridgeDirection getBridgeDirection(int index) {
        return toBridgeSign(bridge).get(index);
    }

    private List<BridgeDirection> toBridgeSign(List<String> bridge) {
        return bridge.stream().map(BridgeDirection::from).collect(Collectors.toList());
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public boolean isEndOfBridge(int index) {
        return index == bridge.size() -1;
    }

}
