package bridge;

import static bridge.result.GameStatus.SUCCESS;

import bridge.domain.BridgeController;
import bridge.result.Result;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeController bridgeController;
    private Integer gameCount;

    public BridgeGame() {
        this.bridgeController = new BridgeController(new BridgeRandomNumberGenerator());
        this.gameCount = 0;
    }

    public void start() {
        bridgeController.inputBridgeSize();
        Result lastResult = playGame();
        bridgeController.endGame(lastResult, gameCount);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Result move() {
        boolean moving = true;
        Result result = Result.getEmptyResult();
        bridgeController.restartGame();
        while (moving) {
            result = bridgeController.inputPlayerMove();
            moving = !result.getGameStatus().isStopGame();
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(Result result) {
        if (result.getGameStatus() == SUCCESS) {
            return false;
        }
        return bridgeController.inputGameCommand();
    }

    private Result playGame() {
        boolean gameStatus = true;
        Result result = Result.getEmptyResult();
        while (gameStatus) {
            gameCount++;
            result = move();
            gameStatus = retry(result);
        }
        return result;
    }
}
