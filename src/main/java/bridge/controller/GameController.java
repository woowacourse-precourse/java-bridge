package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = initBridgeGame();
    }

    public void start() {
        outputView.printNewLine();
        do {
            play();
        } while (retry());

        outputView.printResult(bridgeGame.resultOfFinishedGame());
    }

    public void play() {
        do {
            bridgeGame.move(getValidBridgeMove());
            outputView.printMap(bridgeGame.resultOfMoving().getMoveStatuses());
        } while (!bridgeGame.isEnd());
    }

    private BridgeGame initBridgeGame() {
        return new BridgeGame(getValidBridgeSize());
    }

    private boolean retry() {
        if (bridgeGame.isSuccess()) {
            return false;
        }

        return bridgeGame.retry(getValidGameRetryCommand());
    }

    private int getValidBridgeSize() {
        outputView.printStart();

        return inputView.readBridgeSize();
    }

    private String getValidBridgeMove() {
        outputView.printOrder();

        return inputView.readMoving();
    }

    private String getValidGameRetryCommand() {
        outputView.printRetry();

        return inputView.readGameCommand();
    }
}
