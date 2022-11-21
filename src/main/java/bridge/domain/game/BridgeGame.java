package bridge.domain.game;

import bridge.domain.GameStatus;
import bridge.domain.Move;
import bridge.domain.bridge.Bridge;

import static bridge.domain.GameStatus.FAILED;
import static bridge.domain.GameStatus.SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final GameProgress gameProgress;
    private final Attempt attempt;
    private boolean playing;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.gameProgress = new GameProgress();
        this.attempt = new Attempt();
        this.playing = true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        boolean move = canMove(moving);
        playing = move;
        gameProgress.add(moving, move);
    }

    private boolean canMove(String moving) {
        int position = gameProgress.getPosition();
        return bridge.getBridgeBlock(position).equals(moving);
    }

    public boolean isPlaying() {
        return playing;
    }

    public GameStatus getGameResult() {
        if (gameProgress.isSuccessToCrossBridge(bridge.getSize())) {
            playing = false;
            return SUCCESS;
        }
        return FAILED;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        attempt.addAttempt();
        gameProgress.clear();
        playing = true;
    }

    public GameProgress getGameProgress() {
        return gameProgress;
    }

    public int getAttempt() {
        return attempt.getAttempt();
    }
}
