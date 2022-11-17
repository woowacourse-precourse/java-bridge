package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMovable(String command, int location) {
        if (bridge.get(location).equals(command))
            return true;

        return false;
    }
}
