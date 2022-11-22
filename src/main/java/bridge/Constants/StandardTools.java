package bridge.Constants;

public class StandardTools {

    public static final String NULL = "";
    public static final String ONLY_NUMBER = "^[0-9]*$";
    public static final int UP_SIDE = 1;
    public static final String BRIDGE_HEAD = "[";

    public enum GameStatus {
        PROGRESSING, SUCCEED, FAILED, RETRY, QUIT
    }
}
