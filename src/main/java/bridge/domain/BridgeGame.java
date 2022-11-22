package bridge.domain;

import bridge.utils.Constant;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private User user;

    public BridgeGame() {
        user = new User();
    }

    public void start() {
        do {
            if (CalculationResult.calculateFinalResult()) {
                GameControl.endControl(user.getAttempts());
                return;
            }
            move();
        } while (CalculationResult.calculateResult());
        retry();
    }

    public void move() {
        GameControl.moveAndPrintMap();
    }

    public void retry() {
        String userGameCommand = GameControl.retryControl();
        if (userGameCommand.equals(Constant.QUIT.value)) {
            GameControl.endControl(user.getAttempts());
            return;
        }
        user.plusAttempts();
        user.resetUserMoving();
        start();
    }
}
