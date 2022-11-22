package bridge.view;

import bridge.model.Bridge;
import bridge.model.PlayerStatus;

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


    public static void outputBridge(final Bridge bridge) {
        outputView.printMap(bridge);
    }

    public static void outputGameResult(final Bridge bridge,
                                        final int gameCount,
                                        final PlayerStatus playerStatus) {
        outputView.printResult(bridge, gameCount, playerStatus);
    }
}
