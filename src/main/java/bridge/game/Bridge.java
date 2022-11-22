package bridge.game;

import bridge.etc.GameState;
import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private Integer distance;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.distance = 0;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getBlock(Integer index) {
        return bridge.get(index);
    }

    public GameState pass(String choice) {
        if (getBlock(distance).equals(choice)) {
            distance += 1;
            if (isClear()) {
                return GameState.CLEAR;
            }

            return GameState.CONTINUE;
        }

        return GameState.FAIL;
    }

    private Boolean isClear() {
        return bridge.size() == distance;
    }

}
