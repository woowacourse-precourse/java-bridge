package bridge.domain.state;

import bridge.domain.MoveResult;

public class Success implements State {
    @Override
    public MoveResult state() {
        return MoveResult.SUCCESS;
    }
}
