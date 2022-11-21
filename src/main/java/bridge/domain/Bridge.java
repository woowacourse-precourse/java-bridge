package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean validateMove(String userDirection, int index) {
        if (bridge.get(index).equals(userDirection)) {
            return true;
        }
        return false;
    }

    public String returnCertainIndexUpOrDown(int index) {
        return bridge.get(index);
    }
}
