package bridge.model;

public class BridgeGame {


    private static final String EXIT = "Q";
    private static final String POSSIBILITY_FAILURE = "X";
    private static final String POSSIBILITY_SUCCESS = "O";

    public String move(String presentBridgeDirection, String direction) {
        if (presentBridgeDirection.equals(direction)) {
            return POSSIBILITY_SUCCESS;
        }
        return POSSIBILITY_FAILURE;
    }

    public boolean retry(String gameCommand) {
        if (gameCommand.equals(EXIT)) {
            return false;
        }
        return true;
    }

}
