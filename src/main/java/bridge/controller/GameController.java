package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public GameController() {
    }

    public void run() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        GameResult gameResult = new GameResult(bridgeGame);

        play(bridgeGame, gameResult);
        result(gameResult);
    }

    public void play(BridgeGame bridgeGame, GameResult gameResult) {
        move(bridgeGame, gameResult);
        retry(bridgeGame, gameResult);
    }

    public void move(BridgeGame bridgeGame, GameResult gameResult) {
        for (int idx = 0; idx < bridgeGame.getBridgeSize(); idx++) {
            bridgeGame.move(idx, inputView.readMoving());
            outputView.printMap();
        }
    }

    public void retry(BridgeGame bridgeGame, GameResult gameResult) {
        if (bridgeGame.isClear()) {
            return;
        }
        if (bridgeGame.retry(inputView.readGameCommand())) {
            play(bridgeGame, gameResult);
        }
    }

    public void result(GameResult gameResult) {
        outputView.printResult(gameResult);
    }
}
