package bridge.domain.state;

import bridge.domain.Bridge;

public class Fail extends MovingComplete {
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
}
