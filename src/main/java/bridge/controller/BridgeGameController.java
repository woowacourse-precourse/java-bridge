



package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.identifiers.Direction;
import bridge.views.InputView;
import bridge.views.OutputView;

public class BridgeGameController {

    InputView inputView;
    OutputView outputView;

    BridgeGame bridgeGame;

    public void start() {
        initComponents();
        outputView.printWelcome();
    }

    private void initComponents() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void setDifficulty() {
        retryWhenExceptionOrTryOnce(outputView, () -> {
            int bridgeSize = inputView.readBridgeSize();
            bridgeGame.initComponents(new BridgeRandomNumberGenerator(), bridgeSize);
        });
    }

    public void playGame() {
        while (!bridgeGame.getIsSuccess() && !bridgeGame.isOver()) {
            retryWhenExceptionOrTryOnce(outputView, () -> {
                String rawDirection = inputView.readMoving();
                Direction direction = Direction.parseDirection(rawDirection);
                bridgeGame.move(direction);
            });
            outputView.printMap(bridgeGame.getPlayerPath());
        }
    }

    public boolean askRetry() {
        return false;
    }

    public void end() {

    }

    private static void retryWhenExceptionOrTryOnce(OutputView outputView, Task task) {
        while (true) {
            try {
                task.run();
                break;
            } catch (IllegalArgumentException | IllegalStateException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}

interface Task {
    void run();
}
