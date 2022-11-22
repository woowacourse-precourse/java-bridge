package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final Bridge bridge;
    private List<String> pathOfUser;
    private BridgePath path;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        pathOfUser = new ArrayList<>();
        path = new BridgePath();
    }

    public boolean move(String command) {
        boolean isMovable = isMovableBlock(command);
        pathOfUser.add(command);
        updatePath(command, isMovable);
        return isMovable;
    }

    public void retry() {
        pathOfUser.clear();
        path.clear();
    }

    public boolean isGameClear() {
        return bridge.equals(pathOfUser);
    }

    public String getPath() {
        return path.getPath();
    }

    private boolean isMovableBlock(String command) {
        int indexOfNextBlock = pathOfUser.size();

        return bridge.isMovable(command, indexOfNextBlock);
    }

    private void updatePath(String command, boolean isMovable) {
        path.updatePath(command, isMovable);
    }
}
