package bridge.enums;

public enum Direction {
    DOWN(0, "D"),
    UP(1, "U");

    private String abbr;
    private Integer code;

    Direction(Integer code, String abbr) {
        this.abbr = abbr;
        this.code = code;
    }

    public static Integer getCodeByAbbr(String findAbbr) {
        for (Direction direction : Direction.values()) {
            if (direction.abbr.equals(findAbbr)) {
                return direction.code;
            }
        }

        return null;
    }

    public static String getAbbrByCode(Integer findCode) {
        for (Direction direction : Direction.values()) {
            if (direction.code == findCode) {
                return direction.abbr;
            }
        }

        return null;
    }

    public static int getNumOfDirections() {
        return Direction.values().length;
    }
}
