package bridge.domain.game;

import bridge.constant.Message.LogicExceptionMessage;
import bridge.constant.enums.Moving;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public int size() {
        return bridge.size();
    }

    public String get(int index) {
        return bridge.get(index);
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof  Bridge)) {
            return false;
        }
        boolean isEquals = true;
        for (String direction : bridge) {
            if (! ((Bridge) other).get(bridge.indexOf(direction)).equals(direction)) {
                isEquals = false;
            }
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (String direction : bridge) {
            hashCode += direction.hashCode() * bridge.indexOf(direction);
        }
        return hashCode;
    }

    private void validate(List<String> bridge) {
        if (! bridge.stream().allMatch(direction -> direction.equals(Moving.UP.getValue())
                || direction.equals(Moving.DOWN.getValue()))) {
            throw new IllegalArgumentException(LogicExceptionMessage.WRONG_BRIDGE_DIRECTION);
        }
    }
}
