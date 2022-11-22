package bridge.domain.bridge;

import bridge.BridgeMaker;
import bridge.domain.result.ResultType;
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

    public ResultType move(MoveType moveType) {
        String position = bridge.get(this.index++);
        if (!moveType.isSame(position)) {
            return ResultType.FAIL;
        }
        if (isFinished()) {
            return ResultType.FINISHED;
        }
        return ResultType.SUCCESS;
    }

    private boolean isFinished() {
        return index == bridge.size();
    }

    public void retry() {
        this.index = 0;
    }
}
