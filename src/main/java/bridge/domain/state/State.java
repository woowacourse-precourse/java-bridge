package bridge.domain.state;

import bridge.domain.MoveResult;

public interface State {
    MoveResult state();
}
