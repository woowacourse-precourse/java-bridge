package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.value.BridgeSize;
import bridge.domain.value.GameCommand;
import bridge.domain.value.MovingShape;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void GameRun() {
        outputView.printGameStart();
        BridgeGame bridgeGame = play(inputView.readBridgeSize());
        outputView.printResult(bridgeGame.getBridgeGameResult(), bridgeGame.getGameStatus(), bridgeGame.getBridgeGameCount());
    }

    private BridgeGame play(BridgeSize bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        while (bridgeGame.isRunning()) {
            move(bridgeGame);
            retryOrQuit(bridgeGame);
        }
        return bridgeGame;
    }

    private void move(BridgeGame bridgeGame) {
        MovingShape movingShape = inputView.readMovingShape();
        bridgeGame.move(movingShape);
        outputView.printMap(bridgeGame.getBridgeGameResult());
    }

    private void retryOrQuit(BridgeGame bridgeGame) {
        if (bridgeGame.isRetryOrQuit()) {
            GameCommand gameCommand = inputView.readGameCommand();
            isRetry(bridgeGame, gameCommand);
        }
    }

    private void isRetry(BridgeGame bridgeGame, GameCommand gameCommand) {
        if (gameCommand.isRetry()) {
            bridgeGame.retry();
        }
    }
}
