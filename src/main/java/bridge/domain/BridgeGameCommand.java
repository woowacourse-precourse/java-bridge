package bridge.domain;

import java.util.Arrays;
import java.util.Objects;

public enum BridgeGameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String key;

    BridgeGameCommand(final String key) {
        this.key = key;
    }

    public static BridgeGameCommand checkGameCommand(final String key) {
        return Arrays.stream(values())
                .filter(e -> Objects.equals(e.key, key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("R,Q 만 입력 가능합니다"));
    }
}
