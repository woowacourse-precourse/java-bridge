package bridge.domain.game;

import bridge.domain.bridge.Bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.game.GameStatus.FAILED;
import static bridge.domain.game.GameStatus.SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final List<GameProgress> gameProgress;
    private final Attempt attempt;
    private boolean playing;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.gameProgress = new ArrayList<>();
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
        gameProgress.add(new GameProgress(moving, move));
    }

    private boolean canMove(String moving) {
        int position = gameProgress.size();
        playing = bridge.getBridgeBlock(position).equals(moving);
        return playing;
    }

    private boolean isSuccessToCrossTotalBridge() {
        return (gameProgress.size() == bridge.getSize() &&
                gameProgress.get(gameProgress.size() - 1).isSuccess());
    }

    public boolean isPlaying() {
        return playing;
    }

    public GameStatus getGameResult() {
        if (isSuccessToCrossTotalBridge()) {
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



    public List<GameProgress> getGameProgress() {
        return gameProgress;
    }

    public int getAttempt() {
        return attempt.getAttempt();
    }
}
