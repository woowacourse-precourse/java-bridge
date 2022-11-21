package bridge.enums;

public enum  Command {
    RESTART("R", "r"),
    QUIT("Q", "q");

    private final String upperCode;
    private final String LowerCode;

    Command(String upperCode, String lowerCode) {
        this.upperCode = upperCode;
        LowerCode = lowerCode;
    }

    public static Command check(String input) {
        if (input == RESTART.upperCode || input == RESTART.LowerCode)
            return RESTART;
        else if (input == QUIT.upperCode || input == QUIT.LowerCode)
            return QUIT;
        else return null;
    }
}
