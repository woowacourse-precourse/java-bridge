package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;
import bridge.domain.Player;
import java.util.List;

public class BridgeGameController {

    public void init() {
        int size = InputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeGame bridgeGame = new BridgeGame(size, bridgeNumberGenerator);
        play(bridgeGame);
    }

    private void play(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.getBridge());
        while (!bridgeGame.isGameEnd() && bridgeGame.isPlayerAlive()) {

            String playerChoice = InputView.readMoving();
            bridgeGame.move(playerChoice);

            if (bridgeGame.isPlayerAlive()) {
                OutputView.printMap(bridgeGame);
                bridgeGame.updatePlayer();
                continue;
            }
            if (!bridgeGame.isPlayerAlive()) {
                OutputView.printMap(bridgeGame);
            }
            getGameCommand(bridgeGame);
        }
        OutputView.printResult(bridgeGame);
    }

    private void getGameCommand(BridgeGame bridgeGame) {
        if (InputView.readGameCommand()) {
            bridgeGame.retry();
        }
    }


}
