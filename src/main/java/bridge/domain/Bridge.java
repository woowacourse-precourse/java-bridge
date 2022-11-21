package bridge.domain;

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
        if (isFinished()) {
            return ResultType.FINISHED;
        }
        String position = bridge.get(this.index++);

        if (!moveType.isSame(position)) {
            return ResultType.FAIL;
        }
        return ResultType.SUCCESS;
    }

    private boolean isFinished() {
        return index + 1 == bridge.size();
    }

    public void retry() {
        this.index = 0;
    }
}
