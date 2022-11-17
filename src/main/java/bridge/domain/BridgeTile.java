package bridge.domain;

import java.util.Arrays;

public enum BridgeTile {
    DOWN(0, "D"),
    UP(1, "U");

    private static final String TILE_CODE_ERROR_MESSAGE = "[ERROR] %d는 등록된 다리의 타일 코드가 아닙니다.";
    private static final String TILE_POSITION_ERROR_MESSAGE = "[ERROR] %s는 등록된 다리의 문자가 아닙니다.";

    private final int tileCode;
    private final String tilePosition;

    BridgeTile(int tileCode, String tilePosition) {
        this.tileCode = tileCode;
        this.tilePosition = tilePosition;
    }

    public static BridgeTile findByCode(int tileCode) {
        return Arrays.stream(BridgeTile.values())
                .filter(tile -> tile.tileCode == tileCode)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(TILE_CODE_ERROR_MESSAGE, tileCode)));
    }

    public static BridgeTile findByTilePosition(String tilePosition) {
        return Arrays.stream(BridgeTile.values())
                .filter(tile -> tile.tilePosition.equals(tilePosition))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format(TILE_POSITION_ERROR_MESSAGE, tilePosition)));
    }

    public String getTilePosition() {
        return this.tilePosition;
    }
}
