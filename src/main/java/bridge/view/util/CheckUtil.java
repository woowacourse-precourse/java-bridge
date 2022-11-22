package bridge.view.util;

public class CheckUtil {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    public static int checkInputBridgeSize(int bridgeSize, String message) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(message);
        }
        return bridgeSize;
    }

    public static int checkIsString(String bridgeSize, String message) throws IllegalArgumentException {
        try {
            return Integer.valueOf(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }

    public static String checkInputReadMoving(String readMove, String message) {
        if (!(readMove.equals(UP) || readMove.equals(DOWN))) {
            throw new IllegalArgumentException(message);
        }
        return readMove;
    }

    public static String checkInputReadGameCommand(String gameCommand, String message) {
        if (!(gameCommand.equals(RESTART) || gameCommand.equals(QUIT))) {
            throw new IllegalArgumentException(message);
        }
        return gameCommand;
    }
}
