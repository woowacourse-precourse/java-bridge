package bridge.enums;

public enum GameCases {
    UP_TRUE_SITUATION("U", true, " O ", "   "),
    UP_FALSE_SITUATION("U", false, " X ", "   "),
    DOWN_TRUE_SITUATION("D", true, "   ", " O "),
    DOWN_FALSE_SITUATION("D", false, "   ", " X "),
    ;

    private final String direction;
    private final boolean result;
    private final String upperRowString;
    private final String lowerRowString;

    private GameCases(String direction, boolean result, String upperRowString, String lowerRowString) {
        this.direction = direction;
        this.result = result;
        this.upperRowString = upperRowString;
        this.lowerRowString = lowerRowString;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isResult() {
        return result;
    }

    public String getUpperRowString() {
        return upperRowString;
    }

    public String getLowerRowString() {
        return lowerRowString;
    }
}
