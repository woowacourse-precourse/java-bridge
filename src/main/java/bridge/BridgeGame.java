package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private List<String> user;
    private int tryCount;

    public BridgeGame(int size, BridgeMaker bridgeMaker) {
        user = new ArrayList<>();
        tryCount = 1;
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public int getTryCount() {
        return tryCount;
    }

    public String move(String movingCommand) {
        user.add(movingCommand);
        return bridge.compare(user);
    }

    public void retry() {
        user.clear();
        tryCount++;
    }
}
