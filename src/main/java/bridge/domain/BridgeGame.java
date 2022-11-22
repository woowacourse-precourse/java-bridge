package bridge.domain;


import bridge.util.InputConstant;
import bridge.util.MessageConstant;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final Bridge bridge;
    private List<String> movements;
    private Result result;

    public BridgeGame(Bridge bridge, Result result) {
        this.bridge = bridge;
        this.movements = new ArrayList<>();
        this.result = result;
    }

    public void move(String direction) {
        inputDirection(direction);
        if(hasNotSameDirection()) {
            retry();
        }
    }

    public void retry() throws IllegalArgumentException {
        if(movements.get(movements.size() - 1).equals(InputConstant.UP.getValue())) {
            result.changeUpStairsRecord();
        }
        if(movements.get(movements.size() - 1).equals(InputConstant.DOWN.getValue())) {
            result.changeDownStairsRecord();
        }
        throw new IllegalArgumentException(MessageConstant.ERROR_INPUT_GAME_CONTINUOUS.getValue());
    }

    public void inputDirection(String direction) {
        movements.add(direction);
        result.recordDirection(direction);
    }

    public void initialize(Result result) {
        movements = new ArrayList<>();
        this.result = result;
    }

    public boolean isFinish() {
        return bridge.isFinish(movements.size());
    }

    public boolean hasNotSameDirection() {
        int lastIdx = movements.size() - 1;
        return !bridge.canMoveDirection(movements.get(lastIdx), lastIdx);
    }
}
