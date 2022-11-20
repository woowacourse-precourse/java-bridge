package bridge.domain;

import bridge.domain.bridgeenum.BridgeSize;
import bridge.domain.errorenum.ErrorMessage;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public boolean checkMoveSuccess(String nextPosition, int index) {
        return isNextPositionSame(nextPosition, bridge.get(index));
    }

    public boolean hasReachedEnd(int index) {
        return index == bridge.size();
    }

    private void validate(List<String> bridge) throws IllegalArgumentException {
        if (isNotInRange(bridge.size())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.printMessage());
        }
    }

    private boolean isNotInRange(int size) {
        return size < BridgeSize.MIN.getValue() || size > BridgeSize.MAX.getValue();
    }

    private boolean isNextPositionSame(String nextPosition, String bridgePosition) {
        return nextPosition.equals(bridgePosition);
    }
}
