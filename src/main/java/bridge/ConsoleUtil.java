package bridge;

public class ConsoleUtil {

    static InputView inputView;
    static OutputView outputView;

    static {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public static int inputBridgeSize() {
        return inputView.readBridgeSize();
    }

    public static String inputPlayerMoving() {
        return inputView.readMoving();
    }

    public static String inputGameCommand() {
        return inputView.readGameCommand();
    }


    public static void outputBridge(Bridge bridge) {
        outputView.printMap(bridge);
    }

    public static void outputGameResult(Bridge bridge, int gameCount, PlayerStatus playerStatus) {
        outputView.printResult(bridge, gameCount, playerStatus);
    }
}
