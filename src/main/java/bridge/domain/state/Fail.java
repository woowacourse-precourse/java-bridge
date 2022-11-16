package bridge.domain.state;

import bridge.domain.Bridge;
import bridge.domain.MoveResult;

public class Fail extends MoveComplete {
    public Fail(final Bridge bridge, final String moving) {
        super(bridge, moving);
    }
    
    @Override
    public boolean isMoveFailed() {
        return true;
    }
    
    @Override
    public boolean isGameFinished(final int numberOfMoves) {
        return false;
    }
    
    @Override
    public MoveResult state() {
        return MoveResult.FAIL;
    }
}
