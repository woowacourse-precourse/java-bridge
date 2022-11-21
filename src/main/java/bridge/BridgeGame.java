package bridge;

public class BridgeGame {

    public int move(String command, String[][] bridgeBoard, int position) {
        if (command.equals("U")) {
            if (bridgeBoard[0][position].equals(command)) {
                return position + 1;
            }
            return position;
        }

        if (bridgeBoard[1][position].equals(command)) {
            return position + 1;
        }
        return position;
    }

    public boolean retry(String command) {
        if (command.equals("R")) {
            return true;
        }
        return false;
    }
}
