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
    }

    private static BridgeGame init() {
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
            playRounds(bridgeGame);
            if (!bridgeGame.isPlayerAlive()) {
                getGameCommand(bridgeGame);
            }
        }
        OutputView.printResult(bridgeGame);
    }

    private static void playRounds(BridgeGame bridgeGame) {
        while (!bridgeGame.isGameEnd() && bridgeGame.isPlayerAlive()) {
            String playerChoice = getPlayerChoice();
            bridgeGame.move(playerChoice);
            OutputView.printMap(bridgeGame);
            bridgeGame.nextRound();
        }
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
                    return;
                }
                return;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }
}