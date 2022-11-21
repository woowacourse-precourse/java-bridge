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

    public String getAbbr() {
        return abbr;
    }

    public Integer getCode() {
        return code;
    }

    public static Integer getCodeByAbbr(String abbr) {
        for (Direction direction : Direction.values()) {
            if (direction.getAbbr().equals(abbr)) {
                return direction.getCode();
            }
        }

        return null;
    }

    public static String getAbbrByCode(Integer code) {
        for (Direction direction : Direction.values()) {
            if (direction.getCode() == code) {
                return direction.getAbbr();
            }
        }

        return null;
    }
}
