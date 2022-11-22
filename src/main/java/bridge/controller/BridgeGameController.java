package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.map.BridgeMap;
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
        int size = InputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeGame(size, bridgeNumberGenerator);
    }

    private void play(BridgeGame bridgeGame) {
        while (!bridgeGame.isGameEnd()) {
            bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame.getMap());

            if (!bridgeGame.isPlayerAlive()) {
                bridgeGame.retry(InputView.readGameCommand());
            }
        }
    }

}