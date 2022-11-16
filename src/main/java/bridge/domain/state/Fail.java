package bridge.domain.state;

import bridge.domain.MoveResult;

import java.util.List;

public class Fail extends MoveComplete {
    public Fail(final List<String> bridge) {
        super(bridge);
    }
    
    @Override
    public boolean isGameFinished(final int numberOfMoves) {
        return false;
    }
    
    @Override
    public boolean isMoveFail() {
        return true;
    }
    
    @Override
    public MoveResult state() {
        return MoveResult.FAIL;
    }
}
