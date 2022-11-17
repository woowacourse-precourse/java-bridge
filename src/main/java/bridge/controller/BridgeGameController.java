package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    public static void startGame() {
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
        while (gameStatus && position < bridgeLength) {
            gameStatus = move(bridgeGame, position);
            position++;
        }
        OutputView.printResult(gameStatus, bridgeGame.getPlayResult());
    }

    private static boolean move(BridgeGame bridgeGame, int position) {
        boolean gameStatus = true;
        try {
            gameStatus = bridgeGame.move(position, InputView.readMoving());
            OutputView.printMap(bridgeGame.getPlayResult());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            move(bridgeGame, position);
        }
        return gameStatus;
    }
}
