package bridge.enums;

public enum Move {
    UP("U", "u"),
    DOWN("D", "d");

    private final String upperCode;
    private final String LowerCode;

    Move(String upperCode, String lowerCode) {
        this.upperCode = upperCode;
        LowerCode = lowerCode;
    }

    public static Move check(String input) {
        if (input == UP.upperCode || input == UP.LowerCode)
            return UP;
        else if (input == DOWN.upperCode || input == DOWN.LowerCode)
            return DOWN;
        else return null;
    }
}
