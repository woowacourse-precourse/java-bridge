package bridge;

import java.util.Arrays;

public enum BridgeGameMovingInput {
    UP("U", "위"),
    DOWN("D", "아래");

    private final String key;
    private final String text;

    BridgeGameMovingInput(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public static BridgeGameMovingInput fromKey(String key) {
        return Arrays.stream(BridgeGameMovingInput.values())
                .filter(b -> b.getKey().equals(key))
                .findFirst()
                .orElse(null);
    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }
}
