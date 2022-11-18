package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.utils.generator.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.utils.Constants.MESSAGE_START_BRIDGE_GAME;

public class BridgeGameController {

    public static void startGame() {
        System.out.println(MESSAGE_START_BRIDGE_GAME);
        try {
            makeBridge(InputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startGame();
        }
    }

    private static void makeBridge(int bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame(bridgeSize, new BridgeMaker(new BridgeRandomNumberGenerator()));
        boolean gameStatus = true;
        while (gameStatus && !bridgeGame.gameEnd()) {
            gameStatus = move(bridgeGame);
            gameStatus = gameNotOver(gameStatus, bridgeGame);
        }
        OutputView.printResult(gameStatus, bridgeGame.getPlayer());
    }

    private static boolean move(BridgeGame bridgeGame) {
        boolean gameStatus;
        try {
            gameStatus = bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame.getPlayer());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return move(bridgeGame);
        }
        return gameStatus;
    }

    private static boolean gameNotOver(boolean gameStatus, BridgeGame bridgeGame) {
        if (!gameStatus) {
            gameStatus = retry(bridgeGame);
        }
        return gameStatus;
    }

    private static boolean retry(BridgeGame bridgeGame) {
        try {
            String gameCommand = InputView.readGameCommand();
            return bridgeGame.retry(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retry(bridgeGame);
        }
    }
}
