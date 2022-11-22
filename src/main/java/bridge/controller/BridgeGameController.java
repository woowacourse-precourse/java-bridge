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

    private static boolean move() {
        String command = getMoving();
        boolean result = game.move(command);
        outputView.printMap(game.getUpperBridge());
        outputView.printMap(game.getLowerBridge());
        outputView.printEmptyLine();
        return result;
    }

    private static String getMoving() {
        outputView.printMessage(Message.MOVING);
        while (true) {
            try {
                String command = inputView.readMoving();
                return command;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static boolean retry() {
        String command = getGameCommand();
        return game.retry(command);
    }

    private static String getGameCommand() {
        outputView.printMessage(Message.GAME_COMMAND);
        while (true) {
            try {
                String command = inputView.readGameCommand();
                return command;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static void gameEnd() {
        outputView.printMessage(Message.GAME_RESULT);
        outputView.printMap(game.getUpperBridge());
        outputView.printMap(game.getLowerBridge());
        outputView.printEmptyLine();
        outputView.printResult(game.isClear(), game.getCount());
    }
}
