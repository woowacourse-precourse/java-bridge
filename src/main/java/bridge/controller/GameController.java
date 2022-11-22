package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public GameController() {
    }

    public void run() {
        inputView.printStartMessage();
        BridgeGame bridgeGame = setGame();
        play(bridgeGame);
        result(bridgeGame);
    }

    public BridgeGame setGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        return new BridgeGame(bridge);
    }

    public void play(BridgeGame bridgeGame) {
        move(bridgeGame);
        retry(bridgeGame);
    }

    public void move(BridgeGame bridgeGame) {
        for (int idx = 0; idx < bridgeGame.getBridgeSize(); idx++) {
            boolean pass = bridgeGame.move(idx, Direction.get(inputView.readMoving()));
            outputView.printMap(bridgeGame);
            if (!pass) {
                return;
            }
        }
    }

    public void retry(BridgeGame bridgeGame) {
        if (bridgeGame.isClear().equals(GameResult.SUCCESS)) {
            return;
        }
        if (bridgeGame.retry(Command.get(inputView.readGameCommand()))) {
            play(bridgeGame);
        }
    }

    public void result(BridgeGame bridgeGame) {
        outputView.printResult(bridgeGame);
    }
}
