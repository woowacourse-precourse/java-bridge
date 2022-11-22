package bridge.domain;

import java.util.List;

import static bridge.domain.GameRule.COMMAND_QUIT;
import static bridge.domain.GameRule.COMMAND_RETRY;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final Player player;
    private boolean isPlaying;

    public BridgeGame(List<String> bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
        this.isPlaying = true;
    }

    public boolean judge(String playerMoving) {
        return player.isMovableBy(playerMoving, bridge);
    }

    public void move(String playerMoving) {
        boolean isMovable = judge(playerMoving);
        player.updatePlayerStatus(isMovable, playerMoving);
    }

    public void retry() {
        player.retry();
    }

    public void quit() {
        isPlaying = false;
    }

    public void executeCommand(String command) {
        if (command.equals(COMMAND_RETRY)) {
            retry();
        }

        if (command.equals(COMMAND_QUIT)) {
            quit();
        }
    }

    // 게임 결과
    public String getGameResult() {
        return GameResult.getGameResultBy(isSuccessfullyCompleted());
    }

    public boolean isSuccessfullyCompleted() {
        return player.isArrived(bridge.size());
    }

    public boolean isCompletedOrStopped() {
        return isSuccessfullyCompleted() || !isPlaying;
    }

    // 플레이어 정보 getter
    public String getPlayerStatus() {
        return player.getPlayerStatus();
    }

    public int getPlayerTryCount() {
        return player.getTryCount();
    }

}
