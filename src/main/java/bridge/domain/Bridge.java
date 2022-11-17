package bridge.domain;

import bridge.exception.FailException;
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

    public void move(Direction direction) {
        if (location >= bridgeLength) {
            throw new IllegalStateException();
        }

        if (!Objects.equals(bridge.get(location++), direction.getPosition())) {
            throw new FailException();
        }
    }

    public void restart() {
        this.location = 0;
    }

    public boolean isArrive() {
        return bridgeLength == location;
    }

}
