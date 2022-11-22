package bridge.domain;

import java.util.List;

public class BridgeCalculator {
    private List<String> bridge;
    private int location;

    public BridgeCalculator(List<String> bridge){
        this.bridge = bridge;
        this.location = 0;
    }
}
