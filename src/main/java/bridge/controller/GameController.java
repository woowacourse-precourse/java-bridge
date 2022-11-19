package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;

    public GameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void startGame() {
        outputView.printStartGame();
        outputView.printPleaseInputBridgeLength();
        bridgeGame.makeBridge(inputView.readBridgeSize(), new BridgeRandomNumberGenerator());
        outputView.printNewline();
    }

    public void playGame() {
        do {
            bridgeGame.initPlayer();
            if (movePlayer()) {
                return;
            }
            outputView.printPleaseInputRetry();
        } while (bridgeGame.retry(inputView.readGameCommand()));
    }

    private boolean movePlayer() {
        while (!bridgeGame.isClearGame()) {
            outputView.printChoiceMove();
            if (!bridgeGame.move(inputView.readMoving())) {
                outputView.printMap(bridgeGame.getPlayer());
                return false;
            }
            outputView.printMap(bridgeGame.getPlayer());
        }
        return true;
    }

    public void endGame() {
        outputView.printResult(bridgeGame.getPlayer());
    }
}
