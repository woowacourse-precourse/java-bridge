package bridge;

import bridge.domain.Player;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Player player;

    private List<String> bridge;

    private int tryCount = 1;

    private int location = 0;

    public BridgeGame(Player player) {
        this.player = player;
    }

    public void generate(List<String> bridge) {
        this.bridge = bridge;
    }

    public void move(String moving) {
        if (moving.equals("U")) {
            if (bridge.get(location).equals(moving)) {
                player.correctUpsideBridge(location);
            }
            if (!(bridge.get(location).equals(moving))) {
                player.wrongUpsideBridge(location);
            }
        }

        if (moving.equals("D")) {
            if (bridge.get(location).equals(moving)) {
                player.correctDownsideBridge(location);
            }
            if (!(bridge.get(location).equals(moving))) {
                player.wrongDownsideBridge(location);
            }
        }
        increaseLocation();
    }

    public void retry() {
        player.retry();
        increaseRetry();
        location = 0;
    }

    public boolean isAllAnswer() {
        return player.isAllAnswer(bridge.size());
    }

    public int showTryCount() {
        return tryCount;
    }

    private void increaseRetry() {
        tryCount++;
    }

    private void increaseLocation() {
        location++;
    }
}
