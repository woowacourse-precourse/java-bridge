package bridge;

public class Application {

    public static int BRIDGE_SIZE;
    public static String MOVING;
    public static String GAME_COMMAND;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        try {
            BRIDGE_SIZE = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.err.println(ERROR_MESSAGE);
        }

    }
}
