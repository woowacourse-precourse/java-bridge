package bridge.domain;

import bridge.exception.ErrorMessage;
import bridge.exception.FailException;
import bridge.exception.InvalidInputException;
import java.util.List;
import java.util.Objects;

public class Bridge {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 20;

    private final int bridgeLength;
    private final List<String> bridge;

    private int location;

    public Bridge(List<String> bridge) {
        this.bridgeLength = bridge.size();
        validateBridge(bridgeLength);
        this.bridge = bridge;
    }

    private void validateBridge(int bridgeLength) {
        if (bridgeLength < Bridge.MINIMUM_LENGTH || Bridge.MAXIMUM_LENGTH < bridgeLength) {
            throw new InvalidInputException(ErrorMessage.BRIDGE_LENGTH_IS_BETWEEN_3_AND_20);
        }
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
