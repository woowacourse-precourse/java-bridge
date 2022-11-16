package bridge.domain.state;

import bridge.domain.MoveResult;

import java.util.List;

public class Success implements State {
    @Override
    public MoveResult state() {
        return MoveResult.SUCCESS;
    }
    
    @Override
    public State move(final int currentPosition) {
        return null;
    }
}
