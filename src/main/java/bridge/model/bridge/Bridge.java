package bridge.model.bridge;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
        System.out.println(bridge);
    }

    public static Bridge from(List<String> bridge) {
        return new Bridge(bridge);
    }

    public Iterator<BridgeDirection> getBridgeIterator() {
        return toBridgeSign(bridge).listIterator();
    }

    private List<BridgeDirection> toBridgeSign(List<String> bridge) {
        return bridge.stream().map(BridgeDirection::from).collect(Collectors.toList());
    }

}
