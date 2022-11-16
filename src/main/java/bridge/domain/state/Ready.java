package bridge.domain.state;

import bridge.domain.MoveResult;

public class Ready {
    public MoveResult state() {
        return MoveResult.READY;
    }
}
