package bridge;

import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private Integer step;
    private Boolean quit = false;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.step = 0;
    }

    public Boolean move(String moving) {
        System.out.println(step);
        this.step += 1;
        if (match(moving)) {
            return true;
        }
        return false;
    }

    public Boolean match(String moving) {
        return bridge.get(step - 1).equalsIgnoreCase(moving);
    }

    public Boolean isEnd() {
        return step.equals(bridge.size()) || quit;
    }

    public void quitGame() {
        this.quit = true;
    }

    public List<String> getCurrentBridge() {
        if (step > 0) {
            return bridge.subList(0, step);
        }
        return null;
    }

    public void retry() {
        this.step = 0;
    }
}
