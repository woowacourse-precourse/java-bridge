package bridge;

import java.util.List;
import java.util.Objects;

public class Bridge {

    private final List<String> bridge;
    private final int bridgeLength;
    private int location;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeLength = bridge.size();
    }

    public void move(String input) {
        if (location >= bridgeLength) {
            throw new IllegalArgumentException();
        }

        if (!Objects.equals(bridge.get(location++), input)) {
            throw new IllegalArgumentException();
        }
    }

    public void restart() {
        this.location = 0;
    }

    public boolean isArrive() {
        return bridgeLength == location;
    }

}
