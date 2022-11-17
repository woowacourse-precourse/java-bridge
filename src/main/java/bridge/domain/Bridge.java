package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<Integer> bridge;

    public Bridge(List<Integer> bridge) {
        this.bridge = bridge;
    }

    public boolean isPossibleMove (int index, String moving) {
        int movingSpace = bridge.get(index);
        if (moving.equals("U")) {
            return movingSpace == 1;
        }
        return movingSpace == 0;
    }
}
