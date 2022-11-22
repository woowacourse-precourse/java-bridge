package bridge.domain;

import java.util.Arrays;

import static bridge.exception.BridgeGameEndTypeExceptionMessage.NO_SUCH_BRIDGE_GAME_END_TYPE_EXCEPTION;

public enum BridgeGameEndType {

    END("Q"),
    RESTART("R");

    private final String type;

    BridgeGameEndType(String type) {
        this.type = type;
    }

    public static BridgeGameEndType of(String endType) {
        return Arrays.stream(BridgeGameEndType.values())
                .filter(gameEndType -> gameEndType.type.equals(endType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_BRIDGE_GAME_END_TYPE_EXCEPTION.getMessage()));
    }

    public boolean isEnd() {
        return this == END;
    }
}
