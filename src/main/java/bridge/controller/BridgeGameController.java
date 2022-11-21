package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGameStatus;
import bridge.domain.GameCommand;
import bridge.domain.Moving;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame(bridgeNumberGenerator);
    }

    public void initializeGame() {
        outputView.printGameStartMessage();
        final int bridgeSize = inputView.readBridgeSize();
        bridgeGame.initialize(bridgeSize);
    }

    public void playGame() {
        do {
            run();
            final BridgeGameStatus bridgeGameStatus = bridgeGame.getBridgeGameStatus();
            if (bridgeGameStatus.isGameSuccessfulEnd()) break;
        } while (bridgeGame.retry(inputRetryCommand()));
    }

    private void run() {
        bridgeGame.addRunCount();
        do {
            final Moving nowMoving = inputView.readMoving();
            bridgeGame.move(nowMoving);
            final BridgeGameStatus bridgeGameStatus = bridgeGame.getBridgeGameStatus();
            outputView.printMap(bridgeGameStatus);
        } while (bridgeGame.canMoveContinue());
    }

    private GameCommand inputRetryCommand() {
        return inputView.readGameCommand();
    }

    public void terminateGame() {
        BridgeGameStatus bridgeGameStatus = bridgeGame.getBridgeGameStatus();
        outputView.printResult(bridgeGameStatus);
    }
}
