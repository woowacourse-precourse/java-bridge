package bridge.app;

import bridge.BridgeNumberGenerator;
import bridge.commom.constant.GameState;
import bridge.controller.BridgeController;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
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
            while (isEnd()) {
                move();
                retry();
            }
            close();
        } catch (Exception err) {
            exceptionHandler(err);
        }
    }

    public void start() {
        bridgeController.playGreeting();
        bridgeController.setupGame(bridgeNumberGenerator);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        bridgeController.moveOneStep();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if (isFail()) {
            resetGame();
        }
    }

    private void close() {
        bridgeController.showResult();
    }

    private void resetGame() {
        boolean userSelect = bridgeController.figureOutToRestartGame();
        if (userSelect) {
            bridgeController.restartGame();
        }
    }

    private boolean isEnd() {
        return bridgeController.getNowGameProgress() == GameState.RUNNING;
    }

    private boolean isFail() {
        return bridgeController.getNowGameProgress() == GameState.FAIL;
    }

    private void exceptionHandler(Exception err) {
        System.out.println("[ERROR] " + err.getMessage());
    }
}
