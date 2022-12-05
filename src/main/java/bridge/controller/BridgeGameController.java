package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.function.Supplier;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void GameRun() {
        outputView.printGameStart();
        int bridgeSize = read(inputView::readBridgeSize);
        BridgeGame bridgeGame = play(new BridgeSize(bridgeSize));
        outputView.printResult(bridgeGame.getGameResultDto());
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
        String direction = read(inputView::readMovingDirection);
        bridgeGame.move(Direction.of(direction));
        outputView.printMap(bridgeGame.getMovingResultsDto());
    }

    private void retryOrQuit(BridgeGame bridgeGame) {
        if (bridgeGame.isRetryOrQuit()) {
            String gameCommand = read(inputView::readGameCommand);
            isRetry(bridgeGame, GameCommand.of(gameCommand));
        }
    }

    private void isRetry(BridgeGame bridgeGame, GameCommand gameCommand) {
        if (gameCommand.isRetry()) {
            bridgeGame.retry();
        }
    }

    private <T> T read(Supplier<T> input) {
        try {
            return input.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return read(input);
        }
    }
}
