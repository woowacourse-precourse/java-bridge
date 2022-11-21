package bridge;

import bridge.commom.constant.GameState;
import bridge.controller.BridgeController;

import static bridge.commom.constant.GameMessage.Exception.ERROR_HEADER;

public class BridgeGame {

    private final BridgeController bridgeController;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeGame(BridgeController bridgeController, BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeController = bridgeController;
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public void run() {
        try {
            start();
            while (isRunningMode()) {
                move();
                retry();
            }
            close();
        } catch (Exception err) {
            exceptionHandler(err);
        }
    }

    public void retry() {
        if (isRestartMode()) {
            resetGame();
        }
    }

    public void move() {
        bridgeController.moveOneStep();
    }

    public void start() {
        bridgeController.playGreeting();
        bridgeController.setupGame(bridgeNumberGenerator);
    }

    public void close() {
        bridgeController.showResult();
    }

    private void resetGame() {
        boolean userSelect = bridgeController.figureOutToRestartGame();
        if (userSelect) {
            bridgeController.restartGame();
        }
    }

    private boolean isRunningMode() {
        return bridgeController.getNowGameProgress() == GameState.RUNNING;
    }

    private boolean isRestartMode() {
        return bridgeController.getNowGameProgress() == GameState.FAIL;
    }

    private void exceptionHandler(Exception err) {
        System.out.println(ERROR_HEADER + err.getMessage());
    }
}
