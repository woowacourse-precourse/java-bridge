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
        makeBridge();
    }

    private static void makeBridge() {
        try {
            int bridgeSize = InputView.readBridgeSize();
            BridgeGame bridgeGame = new BridgeGame(bridgeSize, new BridgeMaker(new BridgeRandomNumberGenerator()));
            playGame(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeBridge();
        }
    }

    private static void playGame(BridgeGame bridgeGame) {
        boolean gameContinue = true;
        while (gameContinue && !bridgeGame.gameEnd()) {
            gameContinue = move(bridgeGame);
            gameContinue = determineGameContinues(gameContinue, bridgeGame);
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

    private static boolean determineGameContinues(boolean gameContinue, BridgeGame bridgeGame) {
        if (!gameContinue) {
            gameContinue = decideKeepPlay(bridgeGame);
        }
        return gameContinue;
    }

    private static boolean decideKeepPlay(BridgeGame bridgeGame) {
        try {
            String gameCommand = InputView.readGameCommand();
            return bridgeGame.retry(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return decideKeepPlay(bridgeGame);
        }
    }
}
