package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.identifiers.Direction;
import bridge.identifiers.GameRetry;
import bridge.views.InputView;
import bridge.views.OutputView;

import static bridge.exception.ExceptionCheckedFunction.retryWhenExceptionOrTryOnce;

public class BridgeGameController {

    InputView inputView;
    OutputView outputView;

    BridgeGame bridgeGame;


    public void run() {
        try {
            start();
            setDifficulty();
            do {
                playGame();
            } while (isOneMoreGame());
            end();
        } catch (IllegalAccessException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private boolean isOneMoreGame() throws IllegalAccessException {
        if (bridgeGame.isSuccess()) {
            return false;
        }
        return askRetry();
    }

    public void start() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();

        outputView.printWelcome();
    }

    public void setDifficulty() throws IllegalAccessException {
        retryWhenExceptionOrTryOnce(outputView, () -> {
            int bridgeSize = inputView.readBridgeSize();
            bridgeGame.initComponents(new BridgeRandomNumberGenerator(), bridgeSize);
        });
    }

    public void playGame() throws IllegalAccessException {
        while (!bridgeGame.isSuccess() && !bridgeGame.isGameOver()) {
            retryWhenExceptionOrTryOnce(outputView, () -> {
                String rawDirection = inputView.readMoving();
                Direction direction = Direction.parseDirection(rawDirection);
                bridgeGame.move(direction);
            });
            outputView.printMap(bridgeGame.getPlayerPath());
        }
    }

    public boolean askRetry() throws IllegalAccessException {
        retryWhenExceptionOrTryOnce(outputView, () -> {
            String rawRetry = inputView.readGameCommand();
            GameRetry gameRetry = GameRetry.parseRetry(rawRetry);
            if (gameRetry.equals(GameRetry.QUIT)) {
                bridgeGame.setDead();
            }
        });
        if (bridgeGame.isAlive()) {
            bridgeGame.retry();
        }
        return bridgeGame.isAlive();
    }

    public void end() {
        outputView.printResult(
                bridgeGame.getPlayerPath(),
                bridgeGame.getCountAttempt(),
                bridgeGame.isSuccess()
        );
    }
}