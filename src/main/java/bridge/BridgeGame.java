package bridge;

import java.util.LinkedList;
import java.util.List;

public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private List<String> bridges;
    private final List<String> userInputs = new LinkedList<>();
    private int tries = 0;
    private boolean success = false;

    public BridgeGame(final BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void setupGame(final int size) {
        tries++;
        bridges = bridgeMaker.makeBridge(size);
    }

    public boolean move(final String course) {
        final String nowBridge = bridges.get(userInputs.size());
        userInputs.add(course);
        return course.equals(nowBridge);
    }

    public void retry() {
        userInputs.clear();
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
