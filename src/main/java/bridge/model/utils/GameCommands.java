package bridge.model.utils;

public class GameCommands {
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    private GameCommands() {
    }

    public static String retry() {
        return RETRY;
    }

    public static String quit() {
        return QUIT;
    }
}
