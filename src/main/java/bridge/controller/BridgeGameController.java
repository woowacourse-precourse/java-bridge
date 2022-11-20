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
            makeBridge(InputView.readBridgeSize());
        }
    }

    private static void makeBridge(int bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame(bridgeSize, new BridgeMaker(new BridgeRandomNumberGenerator()));
        boolean gameContinue = true;
        while (gameContinue && !bridgeGame.gameEnd()) {
            gameContinue = move(bridgeGame);
            gameContinue = gameNotOver(gameContinue, bridgeGame);
        }
        OutputView.printResult(gameContinue, bridgeGame.getPlayer());
    }

    private static boolean move(BridgeGame bridgeGame) {
        boolean gameContinue;
        try {
            gameContinue = bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame.getPlayer());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return move(bridgeGame);
        }
        return gameContinue;
    }

    private static boolean gameNotOver(boolean gameContinue, BridgeGame bridgeGame) {
        if (!gameContinue) {
            gameContinue = retry(bridgeGame);
        }
        return gameContinue;
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
