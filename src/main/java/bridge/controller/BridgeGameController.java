package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.views.InputView;
import bridge.views.OutputView;

import java.lang.reflect.Executable;
import java.util.Observable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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

    public boolean isGameDone() {
        return false;
    }

    public void playGame() {

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
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}

interface Task {
    void run();
}
