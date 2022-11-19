package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<BridgeBlock> blocks = new ArrayList<>();
    private final BridgeSize bridgeSize;

    public Bridge(List<String> bridge) {
        for (int position = 0; position < bridge.size(); position++) {
            blocks.add(new BridgeBlock(Direction.from(bridge.get(position)), position));
        }
        bridgeSize = new BridgeSize(blocks.size());
    }

    public int getBridgeSize(){
        return bridgeSize.intValue();
    }
}
