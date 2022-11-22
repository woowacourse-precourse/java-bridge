package bridge.controller;

import bridge.BridgeGame;
import bridge.util.InputView;
import bridge.util.OutputView;
import bridge.constant.Message;

public class BridgeGameController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame game;

    public static void run() {
        start();
    }

    private static void start() {
        outputView.printMessage(Message.GREETING);
        outputView.printEmptyLine();
        game = new BridgeGame();
        int size = getBridgeSize();
        game.start(size);
        outputView.printEmptyLine();
    }

    private static int getBridgeSize() {
        outputView.printMessage(Message.BRIDGE_SIZE);
        while (true) {
            try {
                int size = inputView.readBridgeSize();
                return size;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
