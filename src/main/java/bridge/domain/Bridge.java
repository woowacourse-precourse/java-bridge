package bridge.domain;

import java.util.List;

public class Bridge {
    private static final int BRIDGE_SIZE_LOWER_INCLUSIVE = 3;
    private static final int BRIDGE_SIZE_UPPER_INCLUSIVE = 20;
    private static final String BRIDGE_SIZE_OUT_OF_RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public boolean contain(int index, String movement) {
        if (bridge.get(index).equals(movement)) {
            return true;
        }
        return false;
    }

    public boolean isSame(List<String> bridge) {
        if (this.bridge.equals(bridge)) {
            return true;
        }
        return false;
    }

    private void validate(List<String> bridge) {
        int size = bridge.size();
        if (size < BRIDGE_SIZE_LOWER_INCLUSIVE || size > BRIDGE_SIZE_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE_ERROR);
        }
    }
}
