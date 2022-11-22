package bridge.domain.state;

import bridge.domain.Bridge;

public abstract class Started implements MovingResultState {
    private final Bridge bridge;
    
    Started(final Bridge bridge) {
        this.bridge = bridge;
    }
    
    public Bridge bridge() {
        return bridge;
    }
}
