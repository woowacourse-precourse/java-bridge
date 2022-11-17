package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.utils.Constants.MESSAGE_START_BRIDGE_GAME;

public class BridgeGameController {

    public static void startGame() {
        System.out.println(MESSAGE_START_BRIDGE_GAME);
        try {
            makeBridge(InputView.readBridgeLength());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startGame();
        }
    }

    private static void makeBridge(int bridgeLength) {
        BridgeGame bridgeGame = new BridgeGame(bridgeLength, new BridgeMaker(new BridgeRandomNumberGenerator()));
        boolean gameStatus = true;
        int position = 0;
        while (gameNotOver(gameStatus, bridgeGame) && position < bridgeLength) {
            gameStatus = move(bridgeGame, position);
            position = updatePosition(gameStatus, position);
        }
        OutputView.printResult(gameStatus, bridgeGame.getPlayResult());
    }

    private static int updatePosition(boolean gameStatus, int position) {
        if (gameStatus) {
            return position + 1;
        }
        return position;
    }

    private static boolean move(BridgeGame bridgeGame, int position) {
        boolean gameStatus;
        try {
            gameStatus = bridgeGame.move(position, InputView.readMoving());
            OutputView.printMap(bridgeGame.getPlayResult());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return move(bridgeGame, position);
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
