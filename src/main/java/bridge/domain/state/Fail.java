package bridge.domain.state;

import bridge.domain.MoveResult;

import java.util.List;

public class Fail implements State {
    @Override
    public MoveResult state() {
        return MoveResult.FAIL;
    }
    
    @Override
    public State move(final int currentPosition) {
        return null;
    }
}
