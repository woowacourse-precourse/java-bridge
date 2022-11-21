package bridge.domain.game;

import bridge.domain.bridge.Bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.game.GameStatus.FAILED;
import static bridge.domain.game.GameStatus.PLAYING;
import static bridge.domain.game.GameStatus.SUCCESS;
import static bridge.support.ErrorMessage.TOO_MANY_ATTEMPTS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final List<GameProgress> gameProgress;
    private int attempt;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.gameProgress = new ArrayList<>();
        this.attempt = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus move(String moving) {
        GameStatus status = moveAndGetStatus(moving);
        if (isSuccessToCrossTotalBridge(status)) {
            status = SUCCESS;
        }
        return status;
    }

    private GameStatus moveAndGetStatus(String moving) {
        if (canMove(moving)) {
            gameProgress.add(new GameProgress(moving, true));
            return PLAYING;
        }
        gameProgress.add(new GameProgress(moving, false));
        return FAILED;
    }

    private boolean canMove(String moving) {
        int position = gameProgress.size();
        return bridge.getBridgeBlock(position).equals(moving);
    }

    private boolean isSuccessToCrossTotalBridge(GameStatus status) {
        return (gameProgress.size() == bridge.getSize()) && PLAYING.equals(status);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus retry() {
        checkTooManyAttempts();
        attempt++;
        gameProgress.clear();
        return PLAYING;
    }

    private void checkTooManyAttempts() {
        if (Integer.MAX_VALUE == attempt) {
            throw new IllegalArgumentException(TOO_MANY_ATTEMPTS);
        }
    }

    public List<GameProgress> getGameProgress() {
        return gameProgress;
    }

    public int getAttempt() {
        return attempt;
    }
}
