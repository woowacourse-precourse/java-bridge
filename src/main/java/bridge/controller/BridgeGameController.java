package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.function.Function;
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
        BridgeSize bridgeSize = read(BridgeSize::new, inputView::readBridgeSize);
        BridgeGame bridgeGame = play(bridgeSize);
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
        Direction direction = read(Direction::of, inputView::readMovingDirection);
        bridgeGame.move(direction);
        outputView.printMap(bridgeGame.getMovingResultsDto());
    }

    private void retryOrQuit(BridgeGame bridgeGame) {
        if (bridgeGame.isRetryOrQuit()) {
            GameCommand gameCommand = read(GameCommand::of, inputView::readGameCommand);
            isRetry(bridgeGame, gameCommand);
        }
    }

    private void isRetry(BridgeGame bridgeGame, GameCommand gameCommand) {
        if (gameCommand.isRetry()) {
            bridgeGame.retry();
        }
    }

    private <T, R> R read(Function<T, R> object, Supplier<T> input) {
        while(true) {
            try {
                return object.apply(input.get());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
