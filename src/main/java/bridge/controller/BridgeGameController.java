package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    public void run() {
        OutputView.printStartMessage();
        BridgeGame bridgeGame = init();
        play(bridgeGame);
        OutputView.printResult(bridgeGame);
    }

    private static BridgeGame init() {
        try {
            int size = InputView.readBridgeSize();
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            return new BridgeGame(size, bridgeNumberGenerator);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return init();
        }

    }

    private void play(BridgeGame bridgeGame) {
        while (!bridgeGame.isGameEnd()) {
            move(bridgeGame);
            OutputView.printMap(bridgeGame);
            bridgeGame.nextRound();
            if (!bridgeGame.isPlayerAlive()) {
                getGameCommand(bridgeGame);
            }
        }
    }

    private void move(BridgeGame bridgeGame) {
        String playerChoice = InputView.readMoving();
        bridgeGame.move(playerChoice);
    }

    private static void getGameCommand(BridgeGame bridgeGame) {
        String playerChoice = InputView.readGameCommand();
        bridgeGame.retry(playerChoice);
    }
}