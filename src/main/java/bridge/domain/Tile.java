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

    private final int code;
    private final String positionSign;

    Tile(int code, String positionSign) {
        this.code = code;
        this.positionSign = positionSign;
    }

    public static Tile findByCode(int code) {
        return Arrays.stream(Tile.values())
                .filter(tile -> tile.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(TILE_CODE_ERROR_MESSAGE, code)));
    }

    public static Tile findByPositionSign(String positionSign) {
        return Arrays.stream(Tile.values())
                .filter(tile -> tile.positionSign.equals(positionSign))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format(TILE_POSITION_ERROR_MESSAGE, positionSign)));
    }

    public String getPositionSign() {
        return this.positionSign;
    }

    public String toFormatString(Tile playerTile, boolean isSurvive) {
        if (!this.equals(playerTile)) {
            return String.format(TILE_FORMAT, EMPTY_SIGN);
        }
        if (isSurvive) {
            return String.format(TILE_FORMAT, SUCCESS_SIGN);
        }
        return String.format(TILE_FORMAT, FAIL_SIGN);
    }
}
