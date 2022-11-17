package bridge.model;

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

    @Override
    public boolean equals(Object object) {
        List<String> list = (List<String>) object;

        return bridge.equals(list);
    }
}
