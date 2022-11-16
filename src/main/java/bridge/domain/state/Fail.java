package bridge.domain.state;

import bridge.domain.MoveResult;

public class Fail implements State {
    @Override
    public MoveResult state() {
        return MoveResult.FAIL;
    }
}
