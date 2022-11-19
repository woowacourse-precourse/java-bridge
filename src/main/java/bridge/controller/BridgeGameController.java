package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    public void run() {
        BridgeGame bridgeGame = init();
        play(bridgeGame);
    }

    private static BridgeGame init() {
        OutputView.printStartMessage();
        while (true) {
            try {
                int size = InputView.readBridgeSize();
                BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
                return new BridgeGame(size, bridgeNumberGenerator);
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private void play(BridgeGame bridgeGame) {
        while (!bridgeGame.isGameEnd() && bridgeGame.isPlayerAlive()) {

            String playerChoice = getPlayerChoice();
            bridgeGame.move(playerChoice);

            if (bridgeGame.isPlayerAlive()) {
                OutputView.printMap(bridgeGame);
                bridgeGame.nextRound();
                continue;
            }
            if (!bridgeGame.isPlayerAlive()) {
                OutputView.printMap(bridgeGame);
            }
            getGameCommand(bridgeGame);
        }
        OutputView.printResult(bridgeGame);
    }

    private static String getPlayerChoice() {
        while (true) {
            try {
                return InputView.readMoving();
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private void getGameCommand(BridgeGame bridgeGame) {
        while (true) {
            try {
                if (InputView.readGameCommand()) {
                    bridgeGame.retry();
                }
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }


}