package bridge;

import java.util.Arrays;

public enum BridgeGameCommandInput {
    RETRY("R", "재시도"),
    QUIT("Q", "종료");

    private final String key;
    private final String text;

    BridgeGameCommandInput(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public static BridgeGameCommandInput fromKey(String key) {
        return Arrays.stream(BridgeGameCommandInput.values())
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
