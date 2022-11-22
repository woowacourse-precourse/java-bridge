package bridge.model;

import bridge.resource.InputType;

public class BridgePath {
    private Path upperPath;
    private Path lowerPath;

    public BridgePath() {
        this.upperPath = new Path(InputType.MOVE_UP_COMMAND);
        this.lowerPath = new Path(InputType.MOVE_DOWN_COMMAND);
    }

    public void clear() {
        upperPath.clear();
        lowerPath.clear();
    }

    public void updatePath(String command, boolean isMovable) {
        if (isMovable) {
            upperPath.updateCorrectBlock(command);
            lowerPath.updateCorrectBlock(command);
            return;
        }

        upperPath.updateIncorrectBlock(command);
        lowerPath.updateIncorrectBlock(command);
    }

    public String getPath() {
        return upperPath.getPath() + "\n" + lowerPath.getPath();
    }
}
