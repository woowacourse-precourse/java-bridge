package bridge.domain;

import java.util.Iterator;
import java.util.List;

public class Bridge implements Iterable<BridgeStep> {

    private BridgeSize bridgeSize;
    private List<BridgeStep> steps;

    public Bridge(BridgeSize bridgeSize, List<BridgeStep> steps) {
        this.bridgeSize = bridgeSize;
        this.steps = steps;
    };

    public int size(){
        return steps.size();
    }

    @Override
    public Iterator<BridgeStep> iterator() {
        return steps.iterator();
    }

}
