package bridge.service;

import bridge.GameOverChecker;
import bridge.GameWinChecker;
import bridge.MovementStatusForm;

import java.util.Deque;

public class GameChecker {
    private final GameOverChecker gameOverChecker;
    private final GameWinChecker gameWinChecker;

    public GameChecker(GameOverChecker gameOverChecker, GameWinChecker gameWinChecker) {
        this.gameOverChecker = gameOverChecker;
        this.gameWinChecker = gameWinChecker;
    }

    public boolean isGameOver(Deque<MovementStatusForm> movementStatus, Integer bridgeSize) {
        return gameOverChecker.isOver(movementStatus, bridgeSize);
    }

    public boolean isWin(Deque<MovementStatusForm> movementStatus, Integer bridgeSize) {
        return gameWinChecker.isWin(movementStatus, bridgeSize);
    }
}
