public class Application {

    public static int BRIDGE_SIZE;
    public static String MOVING;
    public static String GAME_COMMAND;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        InputView inputView = new InputView();
        try {
            BRIDGE_SIZE = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.err.println(ERROR_MESSAGE);
        }
    }
}