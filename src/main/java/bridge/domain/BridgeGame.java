package bridge.domain;

import static bridge.rule.MovingOption.isDownside;
import static bridge.rule.MovingOption.isUpside;

import java.util.List;

public class BridgeGame {

    private final Player player;

    private List<String> bridge;

    private int tryCount;

    private int location;

    public BridgeGame(Player player) {
        this.player = player;
    }

    public void generate(List<String> bridge) {
        this.bridge = bridge;
        initLocation();
        initTryCount();
    }

    public void move(String moving) {
        if (isUpside(moving)) {
            checkUpsideBridge(moving);
        }
        if (isDownside(moving)) {
            checkDownsideBridge(moving);
        }
        increaseLocation();
    }

    public void retry() {
        player.retry();
        increaseRetry();
        initLocation();
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

    private void initLocation() {
        location = 0;
    }

    private void initTryCount() {
        tryCount = 1;
    }

    private void checkUpsideBridge(String moving) {
        if (bridge.get(location).equals(moving)) {
            player.correctUpsideBridge(location);
        }
        if (!(bridge.get(location).equals(moving))) {
            player.wrongUpsideBridge(location);
        }
    }

    private void checkDownsideBridge(String moving) {
        if (bridge.get(location).equals(moving)) {
            player.correctDownsideBridge(location);
        }
        if (!(bridge.get(location).equals(moving))) {
            player.wrongDownsideBridge(location);
        }
    }
}
