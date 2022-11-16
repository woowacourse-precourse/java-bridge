package bridge.domain.state;

import bridge.domain.MoveResult;

import java.util.List;

public interface State {
    MoveResult state();
    
    State move(final int currentPosition);
}
