package bridge.domain;

import bridge.BridgeMaker;
import java.util.List;

public class Bridge {
    private final BridgeMaker bridgeMaker;
    private List<String> bridge;
    private int index = 0;

    public Bridge(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;

    }

    public void create(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }

    public Result move(MoveType moveType) {
        String position = bridge.get(this.index++);
        List<String> crossedBridge = bridge.subList(0, this.index);
        if (moveType.isSame(position)) {
            return Result.success(crossedBridge);
        }
        return Result.fail(crossedBridge);
    }
}
