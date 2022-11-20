package bridge.domain;


import bridge.util.InputConstant;
import bridge.util.MessageConstant;

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
        if(inputs.get(inputs.size() - 1).equals(InputConstant.UP.getValue())) {
            result.changeUpStairsRecord();
        }
        if(inputs.get(inputs.size() - 1).equals(InputConstant.DOWN.getValue())) {
            result.changeDownStairsRecord();
        }
        throw new IllegalArgumentException(MessageConstant.ERROR_INPUT_GAME_CONTINUOUS.getValue());
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
