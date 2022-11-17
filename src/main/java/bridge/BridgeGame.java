package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private List<String> pathOfUser;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        pathOfUser = new ArrayList<>();
    }

    public boolean move(String command) {
        boolean isMovable = isMovableBlock(command);
        pathOfUser.add(command);

        return isMovable;
    }

    public void retry() {
        pathOfUser.clear();
    }

    private boolean isMovableBlock(String command) {
        int indexOfNextBlock = pathOfUser.size();

        return bridge.isMovable(command, indexOfNextBlock);
    }
}
