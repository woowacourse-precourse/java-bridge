package bridge;

public class BridgeGame {

    public int move(String command, String[][] bridgeBoard, int position) {
        if (command.equals(Constants.UPSIDE)) {
            return compareUpSide(command, bridgeBoard, position);
        }
        return compareDownSide(command, bridgeBoard, position);
    }

    public int compareUpSide(String command, String[][] bridgeBoard, int position) {
        if (bridgeBoard[0][position].equals(command)) {
            return position + 1;
        }
        return position;
    }

    public int compareDownSide(String command, String[][] bridgeBoard, int position) {
        if (bridgeBoard[1][position].equals(command)) {
            return position + 1;
        }
        return position;
    }

    public boolean retry(String command) {
        if (command.equals(Constants.RESTART)) {
            return true;
        }
        return false;
    }
}
