package bridge.domain.state;

import bridge.domain.MoveResult;

import java.util.List;

public class Ready implements State {
    private final List<String> bridge;
    
    public Ready(final List<String> bridge) {
        this.bridge = bridge;
    }
    
    @Override
    public MoveResult state() {
        return MoveResult.READY;
    }
    
    @Override
    public State move(final int currentPosition) {
        return new Success();
    }
}
