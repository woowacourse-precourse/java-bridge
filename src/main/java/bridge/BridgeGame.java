package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private Integer step;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.step = 0;
    }

    public Boolean move(String moving) {
        if (match(moving)) {
            this.step += 1;
            return true;
        }
        return false;
    }

    public Boolean match(String moving) {
        return bridge.get(step).equals(moving);
    }

    public Boolean isEnd() {
        return step > bridge.size();
    }

    public List<String> getCurrentBridge() {
        if (step > 0) {
            return bridge.subList(0, step - 1);
        }
        return null;
    }

    public void retry() {
        this.step = 0;
    }
}
