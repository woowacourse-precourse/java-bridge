package bridge.enums;

public enum Direction {
    UP(0, "U"),
    DOWN(1, "D");

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
}
