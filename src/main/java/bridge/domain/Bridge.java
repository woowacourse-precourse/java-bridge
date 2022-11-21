package bridge.domain;

import java.util.List;

public class Bridge {
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;

    private int length;
    private List<String> bridge;

    Bridge(int length, List<String> bridge) {
        validate(length, bridge);
        this.length = length;
        this.bridge = bridge;
    }

    Bridge(List<String> bridge) {
        this.length = bridge.size();
        this.bridge = bridge;
    }

    private void validate(int length, List<String> bridge) {
        if (bridge.size() != length) {
            throw new IllegalArgumentException("[ERROR] bridge size mismatch");
        }
        for (String b : bridge) {
            Move.from(b);
        }
    }

    public static void validateLength(int length) {
        if (length < BRIDGE_SIZE_MIN || BRIDGE_SIZE_MAX < length) {
            throw new IllegalArgumentException("[ERROR] bridge size mismatch");
        }
    }

    public void addBlock(String upDown) {
        bridge.add(upDown);
        addLength();
        validate(length, bridge);
    }

    private void addLength() {
        length++;
    }

    @Override
    public String toString() {
        if (bridge.size() == 0) {
            return "";
        }
        String result = "";
        for (String bridge : this.bridge) {
            result += bridge;
        }
        return result;
    }
}
