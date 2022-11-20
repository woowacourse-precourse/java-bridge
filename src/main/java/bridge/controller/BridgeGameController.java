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
        do {
            playRounds(bridgeGame);
            if (!bridgeGame.isPlayerAlive()) {
                getGameCommand(bridgeGame);
            }
        } while (!bridgeGame.isGameEnd() && bridgeGame.isPlayerAlive());
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
        return InputView.readMoving();
    }

    private void getGameCommand(BridgeGame bridgeGame) {
        if (InputView.readGameCommand()) {
            bridgeGame.retry();
        }
    }
}