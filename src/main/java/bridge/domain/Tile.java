package bridge.domain;

import java.util.Arrays;

public enum Tile {
    UP(1, "U"),
    DOWN(0, "D");

    private static final String TILE_CODE_ERROR_MESSAGE = "[ERROR] %d는 등록된 다리의 타일 코드가 아닙니다.";
    private static final String TILE_POSITION_ERROR_MESSAGE = "[ERROR] %s는 등록된 다리의 문자가 아닙니다.";

    private static final String TILE_FORMAT = " %s ";
    private static final String SUCCESS_SIGN = "O";
    private static final String FAIL_SIGN = "X";
    private static final String EMPTY_SIGN = " ";

    private final int tileCode;
    private final String tilePosition;

    Tile(int tileCode, String tilePosition) {
        this.tileCode = tileCode;
        this.tilePosition = tilePosition;
    }

    public static Tile findByCode(int tileCode) {
        return Arrays.stream(Tile.values())
                .filter(tile -> tile.tileCode == tileCode)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(TILE_CODE_ERROR_MESSAGE, tileCode)));
    }

    public static Tile findByTilePosition(String tilePosition) {
        return Arrays.stream(Tile.values())
                .filter(tile -> tile.tilePosition.equals(tilePosition))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format(TILE_POSITION_ERROR_MESSAGE, tilePosition)));
    }

    public String getTilePosition() {
        return this.tilePosition;
    }

    public String toString(Tile bridgeTile, Tile playerTile) {
        if (!this.equals(playerTile)) {
            return String.format(TILE_FORMAT, EMPTY_SIGN);
        }
        if(this.equals(bridgeTile)){
            return String.format(TILE_FORMAT, SUCCESS_SIGN);
        }
        return String.format(TILE_FORMAT, FAIL_SIGN);
    }
}
