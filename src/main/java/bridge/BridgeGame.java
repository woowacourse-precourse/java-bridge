package bridge;

import java.util.ArrayList;
import java.util.List;

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

    public boolean isGameClear() {
        return bridge.equals(pathOfUser);
    }

    private boolean isMovableBlock(String command) {
        int indexOfNextBlock = pathOfUser.size();

        return bridge.isMovable(command, indexOfNextBlock);
    }
}
