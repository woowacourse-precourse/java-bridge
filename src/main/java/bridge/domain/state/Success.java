package bridge.domain.state;

import bridge.domain.Bridge;

public class Success extends MoveComplete {
    public Success(final Bridge bridge, final String moving) {
        super(bridge, moving);
    }
    
    @Override
    public boolean isMoveFailed() {
        return false;
    }
    
    @Override
    public boolean isGameFinished(final int numberOfMoves) {
        return bridge().isSameWithBridgeSize(numberOfMoves);
    }
}
