package bridge.domain;

import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }
    public boolean matchMoving(int index, String move) {
        return bridge.get(index).equals(move);
    }

}
