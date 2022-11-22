package bridge.domain.bridge;

import bridge.BridgeMaker;
import bridge.BridgeSizeConstant;
import bridge.domain.result.ResultType;
import java.util.List;

public class Bridge {
    private final BridgeMaker bridgeMaker;
    private List<String> bridge;
    private int index = 0;

    public Bridge(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;

    }

    public void create(String inputSize) {
        validateIsNumber(inputSize);
        int size = Integer.parseInt(inputSize);
        validateSizeRange(size);
        bridge = bridgeMaker.makeBridge(size);
    }

    private void validateIsNumber(String inputSize) {
        if (!inputSize.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력해야 합니다.");
        }
    }

    private void validateSizeRange(int size) {
        if (size > BridgeSizeConstant.MAX_BRIDGE_SIZE || size < BridgeSizeConstant.MIN_BRIDGE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
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
