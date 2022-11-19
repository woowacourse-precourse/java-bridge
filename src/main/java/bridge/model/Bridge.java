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

    public MoveResult cross(BridgeBlock bridgeBlock) {
        if (canCross(bridgeBlock)) {
            return MoveResult.SUCCESS;
        }
        return MoveResult.FAIL;
    }

    private boolean canCross(BridgeBlock bridgeBlock) {
        return blocks.stream()
            .anyMatch((b) -> b.equals(bridgeBlock));
    }

    public int getBridgeSize() {
        return bridgeSize.intValue();
    }
}
