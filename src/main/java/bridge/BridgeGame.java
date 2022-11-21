package bridge;

import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    public Integer step;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.step = 0;
    }

    public void move(String moving) {
        if (step > bridge.size()) {
//            succeed
        }
        if (match(moving)) {
            this.step += 1;
            System.out.println("match~");
        }
        System.out.println("die~");
        this.step = 0;
//        ask retry
    }

    public Boolean match(String moving) {
        return bridge.get(step).equals(moving);
    }

    public void retry() {
    }
}
