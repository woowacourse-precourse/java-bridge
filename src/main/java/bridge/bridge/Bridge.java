package bridge.bridge;

import static bridge.exception.IllegalArgumentExceptionMessage.ILLEGAL_BRIDGE_LENGTH;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    public static final int BRIDGE_LOWER_INCLUSIVE = 3;
    public static final int BRIDGE_UPPER_INCLUSIVE = 20;
    private final List<String> state;

    public Bridge() {
        this.state = new ArrayList<>();
    }

    public Bridge(List<String> state) throws IllegalArgumentException {
        validateBridgeSize(state.size());
        this.state = state;
    }

    private void validateBridgeSize(int bridgeSize) throws IllegalArgumentException {
        if (BRIDGE_LOWER_INCLUSIVE > bridgeSize || bridgeSize > BRIDGE_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(ILLEGAL_BRIDGE_LENGTH.getMessage());
        }
    }

    public int size() {
        return state.size();
    }

    public String get(int index) {
        return state.get(index);
    }

    public void add(String s) {
        state.add(s);
    }

    public void clear() {
        state.clear();
    }
}
