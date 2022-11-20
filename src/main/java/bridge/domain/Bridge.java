package bridge.domain;

import java.util.List;

public class Bridge {
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
            Move.fromString(b);
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
