package bridge.controller;

import bridge.constant.GameCommand;
import bridge.constant.MovingDirection;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView,
        BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void startGame() {
        outputView.printStartPhrase();
        outputView.printInputBridgeSizePhrase();
        bridgeGame.setBridge(inputView.readBridgeSize());
    }

    public void onGame() {
        outputView.printOnGamePhrase();
        MovingDirection movingDirection = inputView.readMoving();
        bridgeGame.move(movingDirection);
        outputView.printMap(bridgeGame);
    }

    public boolean isNotFailure() {
        if (!bridgeGame.fail()) {
            return true;
        }
        outputView.printRetryOrQuitPhrase();
        GameCommand gameCommand = inputView.readGameCommand();
        if (gameCommand == GameCommand.R) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    public void endGame() {
        outputView.printResult(bridgeGame);
    }

}
