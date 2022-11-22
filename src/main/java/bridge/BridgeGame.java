package bridge;

import java.util.List;

public class BridgeGame {
    private final Bridge bridge;

    private int attemptCount;

    public BridgeGame(List<String> blocks) {
        this.bridge = new Bridge(blocks);
        this.attemptCount = 1;
    }

    public void move(String moving) {
        if (bridge.isArrived()) {
            throw new IllegalStateException("[ERROR] 이미 도착했습니다.");
        }

        if (bridge.inProgress()) {
            bridge.visit(BlockPosition.from(moving));
            return;
        }

        throw new IllegalStateException("[ERROR] 게임이 종료되었습니다.");
    }

    public void retry() {
        if (inProgress()) {
            throw new IllegalStateException("[ERROR] 게임이 진행중입니다.");
        }

        if (isSuccess()) {
            throw new IllegalStateException("[ERROR] 이미 성공했습니다.");
        }

        bridge.reset();
        attemptCount++;
    }

    public boolean inProgress() {
        return bridge.inProgress();
    }

    public boolean isSuccess() {
        return bridge.isArrived();
    }

    public List<Block> bridge() {
        return bridge.blocks();
    }

    public int attemptCount() {
        return attemptCount;
    }
}
