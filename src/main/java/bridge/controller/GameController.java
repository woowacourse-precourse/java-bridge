package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        final BridgeGame bridgeGame = initBridgeGame();
        outputView.printNewLine();

        do {
            play(bridgeGame);
        } while (retry(bridgeGame));

        outputView.printResult(bridgeGame.resultOfFinishedGame());
    }

    private void play(final BridgeGame bridgeGame) {
        do {
            bridgeGame.move(getValidBridgeMove());
            outputView.printMap(bridgeGame.resultOfMoving().getMoveStatuses());
        } while (!bridgeGame.isEnd());
    }

    private boolean retry(final BridgeGame bridgeGame) {
        if (bridgeGame.isSuccess()) {
            return false;
        }

        return bridgeGame.retry(getValidGameRetryCommand());
    }

    private BridgeGame initBridgeGame() {
        return new BridgeGame(getValidBridgeSize());
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
