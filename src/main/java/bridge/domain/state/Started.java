package bridge.domain.state;

import java.util.List;

public abstract class Started implements State {
    private final List<String> bridge;
    
    Started(final List<String> bridge) {
        this.bridge = bridge;
    }
    
    public List<String> bridge() {
        return bridge;
    }
}
