package bridge.domain;


import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final Bridge bridge;
    private List<String> inputs;
    private Result result;

    public BridgeGame(Bridge bridge, Result result) {
        this.bridge = bridge;
        this.inputs = new ArrayList<>();
        this.result = result;
    }

    public void move(String direction) {
        inputDirection(direction);
        if(hasNotSameDirection()) {
            retry();
        }
    }

    public void retry() throws IllegalArgumentException {
        if(inputs.get(inputs.size() - 1).equals("U")) {
            result.changeUpStairsRecord();
        }
        if(inputs.get(inputs.size() - 1).equals("D")) {
            result.changeDownStairsRecord();
        }
        throw new IllegalArgumentException("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void inputDirection(String direction) {
        inputs.add(direction);
        result.recordDirection(direction);
    }

    public void initialize(Result result) {
        inputs = new ArrayList<>();
        this.result = result;
    }

    public boolean isFinish() {
        return bridge.isFinish(inputs.size());
    }

    public boolean hasNotSameDirection() {
        int lastIdx = inputs.size() - 1;
        return !bridge.canMoveDirection(inputs.get(lastIdx), lastIdx);
    }
}
