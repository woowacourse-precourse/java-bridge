package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.service.constant.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.constant.RetryOptions;

import java.util.function.Supplier;

public class GameController {
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    private static final BridgeGame game = BridgeGame.getInstance();

    public static GameController instance = new GameController();

    public static GameController getInstance() {
        return instance;
    }

    private GameController() {}

    public BridgeGame create() {
        try {
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return create();
        }
    }

    public void operate (Bridge map, User user) {
        while (user.getStatus() == GameStatus.PLAYING) {
            game.move(map, user, requestStringInput(inputView::readMoving));
            outputView.printMap(game.obtainGameLog(map, user));
            outputView.insertLineBreak();
            operateRetryOption(user);
        }
    }

    private void operateRetryOption (User user) {
        if (user.getStatus() == GameStatus.FAIL) {
            String retryOption = requestStringInput(inputView::readRetryOption);
            if (retryOption.equals(RetryOptions.RETRY.get())) {
                game.retry(user);
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

    public void finish (Bridge map, User user) {
        outputView.printResult(
                game.obtainGameLog(map, user),
                game.isGameCleared(user),
                user.getAttemptCount()
        );
    }
}
