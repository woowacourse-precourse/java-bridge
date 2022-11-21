package bridge.domain.game;

import bridge.domain.bridge.Bridge;

import static bridge.domain.game.GameStatus.FAILED;
import static bridge.domain.game.GameStatus.PLAYING;
import static bridge.domain.game.GameStatus.SUCCESS;

public class BridgeGame {

    private final Bridge bridge;
    private final GameProgress gameProgress;
    private final Attempt attempt;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.gameProgress = new GameProgress();
        this.attempt = new Attempt();
    }

    public GameStatus move(String move) {
        GameStatus status = moveAndGetStatus(move);
        if (isSuccessToCrossBridge(status)) {
            status = SUCCESS;
        }
        return status;
    }

    private GameStatus moveAndGetStatus(String move) {
        if (canMove(move)) {
            gameProgress.add(move, true);
            return PLAYING;
        }
        gameProgress.add(move, false);
        return FAILED;
    }

    private boolean isSuccessToCrossBridge(GameStatus status) {
        return gameProgress.getPosition() == bridge.getSize() && PLAYING.equals(status);
    }

    private boolean canMove(String moving) {
        int position = gameProgress.getPosition();
        return bridge.getBridgeBlock(position).equals(moving);
    }

    public GameStatus retry() {
        attempt.addAttempt();
        gameProgress.clear();
        return PLAYING;
    }

    public GameProgress getGameProgress() {
        return gameProgress;
    }

    public int getAttempt() {
        return attempt.getAttempt();
    }
}
