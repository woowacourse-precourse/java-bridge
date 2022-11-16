package bridge.domain.state;

import bridge.domain.MoveResult;

import java.util.List;

public class Fail extends Started {
    public Fail(final List<String> bridge) {
        super(bridge);
    }
    
    @Override
    public MoveResult state() {
        return MoveResult.FAIL;
    }
    
    @Override
    public State move(final int currentPosition) {
        return null;
    }
    
    @Override
    public boolean isMoveFail() {
        return true;
    }
}
