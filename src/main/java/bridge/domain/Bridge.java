package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;

    private int length = 0;
    private List<String> bridge;

    public Bridge() {
        bridge = new ArrayList<String>();
    }

    public Bridge(int length, List<String> bridge) {
        validate(length, bridge);
        this.length = length;
        this.bridge = bridge;
        validateLength(this.length);
    }

    public Bridge(List<String> bridge) {
        this.length = bridge.size();
        this.bridge = bridge;
        validate(this.length, this.bridge);
        validateLength(this.length);
    }

    private void validate(int length, List<String> bridge) {
        if (bridge.size() != length) {
            throw new IllegalArgumentException("다리 사이즈가 올바르지 않습니다. (현재:" + length + ")");
        }
        for (String b : bridge) {
            Move.from(b);
        }
    }

    public static void validateLength(int length) {
        if (length < BRIDGE_SIZE_MIN || BRIDGE_SIZE_MAX < length) {
            throw new IllegalArgumentException("다리 길이가 범위를 벗어났습니다. (현재:" + length + ")");
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

    public List<String> getBridge() {
        return bridge;
    }
}
