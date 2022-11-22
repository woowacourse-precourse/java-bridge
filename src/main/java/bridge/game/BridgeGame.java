package bridge.game;

import static bridge.result.GameResult.SUCCESS;

import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeController;
import bridge.result.Result;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final Integer START_GAME_COUNT = 0;

    private final BridgeController bridgeController;
    private final GameController gameController;
    private Integer gameCount;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator) {
        this.gameController = new GameController();
        this.bridgeController = new BridgeController(bridgeNumberGenerator);
        this.gameCount = START_GAME_COUNT;
    }

    public void start() {
        bridgeController.makeBridge();
        Result lastResult = playGame();
        gameController.endGame(lastResult, gameCount);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private Result move() {
        boolean moving = true;
        Result result = Result.getEmptyResult();
        while (moving) {
            result = bridgeController.toMove();
            moving = result.getGameStatus().isStopGame();
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean retry(Result result) {
        gameCount++;
        bridgeController.resetGame();
        if (result.getGameStatus() == SUCCESS) {
            return false;
        }
        return gameController.commandTheGame();
    }

    private Result playGame() {
        boolean gameStatus = true;
        Result result = Result.getEmptyResult();
        while (gameStatus) {
            result = move();
            gameStatus = retry(result);
        }
        return result;
    }
}
