package bridge.domain.state;

import bridge.domain.MoveResult;

public interface State {
    MoveResult state();
    
    State move(final int currentPosition);
    
    boolean isMoveFail();
}
