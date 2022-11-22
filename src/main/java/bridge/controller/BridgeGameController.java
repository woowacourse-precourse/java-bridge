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
        while (!bridgeGame.getIsSuccess() && !bridgeGame.isGameOver()) {
            retryWhenExceptionOrTryOnce(outputView, () -> {
                String rawDirection = inputView.readMoving();
                Direction direction = Direction.parseDirection(rawDirection);
                bridgeGame.move(direction);
            });
            outputView.printMap(bridgeGame.getPlayerPath());
        }
    }

    public boolean askRetry() {
        askValidRetry();
        if (bridgeGame.isAlive())
            bridgeGame.retry();

        return bridgeGame.isAlive();
    }

    public boolean isSuccess(){
        return bridgeGame.getIsSuccess();
    }

    private void askValidRetry(){
        retryWhenExceptionOrTryOnce(outputView, () -> {
            String rawRetry = inputView.readGameCommand();
            GameRetry gameRetry = GameRetry.parseRetry(rawRetry);
            if (gameRetry.equals(GameRetry.QUIT)) {
                bridgeGame.setDead();
            }
        });
    }

    public void end() {
        outputView.printResult(
                bridgeGame.getPlayerPath(),
                bridgeGame.getIsSuccess()
        );
    }
}