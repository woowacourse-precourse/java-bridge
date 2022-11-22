package bridge.model;

public class BridgeGame {

    public String move(String presentBridgeDirection, String direction) {
        if (presentBridgeDirection.equals(direction)) {
            return "O";
        }
        return "X";
    }

    public boolean retry(String gameCommand) {
        if (gameCommand.equals("Q")) {
            return false;
        }
        return true;
    }

}
