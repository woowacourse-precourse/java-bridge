package bridge.domain;

import java.util.Arrays;

public enum Tile {
    UP(1, "U"),
    DOWN(0, "D");

    private static final String CODE_ERROR_MESSAGE_FORMAT = "[ERROR] %d는 등록된 다리의 타일 코드가 아닙니다.";
    private static final String DIRECTION_ERROR_MESSAGE_FORMAT = "[ERROR] %s는 등록된 다리의 문자가 아닙니다.";

    private static final String TILE_MAP_EXPRESSION_FORMAT = " %s ";
    private static final String SUCCESS_SIGN = "O";
    private static final String FAIL_SIGN = "X";
    private static final String EMPTY_SIGN = " ";

    private final int code;
    private final String directionSign;

    Tile(int code, String directionSign) {
        this.code = code;
        this.directionSign = directionSign;
    }

    public static Tile findByCode(int code) {
        return Arrays.stream(Tile.values())
                .filter(tile -> tile.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(CODE_ERROR_MESSAGE_FORMAT, code)));
    }

    public static Tile findByDirectionSign(String directionSign) {
        return Arrays.stream(Tile.values())
                .filter(tile -> tile.directionSign.equals(directionSign))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format(DIRECTION_ERROR_MESSAGE_FORMAT, directionSign)));
    }

    public String getDirectionSign() {
        return this.directionSign;
    }

    public String toMapString(Tile playerTile, boolean isSurvive) {
        if (!this.equals(playerTile)) {
            return String.format(TILE_MAP_EXPRESSION_FORMAT, EMPTY_SIGN);
        }
        if (isSurvive) {
            return String.format(TILE_MAP_EXPRESSION_FORMAT, SUCCESS_SIGN);
        }
        return String.format(TILE_MAP_EXPRESSION_FORMAT, FAIL_SIGN);
    }
}
