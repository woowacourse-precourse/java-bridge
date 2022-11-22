package bridge.view;

public class InputView {
    private static final int BRIDGE_SIZE = 1;
    private static final int MOVING = 2;
    private static final int GAME_COMMAND = 3;
    private String input;

    public String readBridgeSize() {
        while (true) {
            input = tryCatch(BRIDGE_SIZE);
            break;
        }
        return input;
    }


    public String readMoving() {
        while (true) {
            input = tryCatch(MOVING);
            break;
        }
        return input;
    }

    public String readGameCommand() {
        while (true) {
            input = tryCatch(GAME_COMMAND);
            break;
        }
        return input;
    }
}
