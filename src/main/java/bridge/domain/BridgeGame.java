package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    User user;

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
        if (userGameCommand.equals("Q")) {
            GameControl.endControl(user.getAttempts());
            return;
        }
        user.plusAttempts();
        user.resetUserMoving();
        start();
    }
}
