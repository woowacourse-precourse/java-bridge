package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.constant.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.constant.RetryOptions;

import java.util.function.Supplier;

public class GameController {
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    public static GameController instance = new GameController();

    public static GameController getInstance() {
        return instance;
    }

    private GameController() {}

    public BridgeGame create() {
        try {
            return new BridgeGame(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return create();
        }
    }

    public void operate (BridgeGame game) {
        while (game.getStatus() == GameStatus.PLAYING) {
            game.move(requestStringInput(inputView::readMoving));
            outputView.printMap(game.obtainGameLog());
            outputView.insertLineBreak();
            operateRetryOption(game);
        }
    }

    private void operateRetryOption (BridgeGame game) {
        if (game.getStatus() == GameStatus.FAIL) {
            String retryOption = requestStringInput(inputView::readRetryOption);
            if (retryOption.equals(RetryOptions.RETRY.get())) {
                game.retry();
            }
        }
    }

    private String requestStringInput(Supplier<String> readStringInput) {
        try {
            return readStringInput.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return requestStringInput(readStringInput);
        }
    }

    public void finish (BridgeGame game) {
        outputView.printResult(
                game.obtainGameLog(),
                game.isGameCleared(),
                game.getAttemptCount()
        );
    }
}
