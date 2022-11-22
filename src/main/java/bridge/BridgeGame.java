package bridge;

import java.util.List;

public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private List<String> bridges;
    private int tries = 1;
    private int nowIndex = 0;
    private boolean success = false;

    public BridgeGame(final BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void setupGame(final int size) {
        bridges = bridgeMaker.makeBridge(size);
    }

    public boolean move(final String course) {
        final String nowBridge = bridges.get(nowIndex);
        nowIndex++;
        return course.equals(nowBridge);
    }

    public void retry() {
        nowIndex = 0;
        tries++;
    }

    public void success() {
        if (this.success) {
            throw new IllegalStateException("[ERROR] 이미 성공한 게임입니다.");
        }
        this.success = true;
    }

    public int getBridgeSize() {
        return bridges.size();
    }

    public int getTries() {
        return tries;
    }

    public boolean isSucceed() {
        return success;
    }
}
