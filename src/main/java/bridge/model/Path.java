package bridge.model;

import bridge.resource.InputType;

public class Path {
    private static final String correctBlock = " O ]";
    private static final String incorrectBlock = " X ]";
    private static final String unselectedBlock = "   ]";

    private String upperPath;
    private String lowerPath;

    public Path() {
        this.upperPath = "[";
        this.lowerPath = "[";
    }

    public String getPath() {
        return upperPath + "\n" + lowerPath;
    }

    public void clear() {
        this.upperPath = "[";
        this.lowerPath = "[";
    }

    public void updatePath(String command, boolean isMovable) {
        upperPath = upperPath.replace("]", "|");
        lowerPath = lowerPath.replace("]", "|");

        if (isMovable)
            updateCorrectBlock(command);
        if (!isMovable)
            updateIncorrectBlock(command);
    }

    private void updateCorrectBlock(String command) {
        if (command.equals(InputType.MOVE_UP_COMMAND.getCommand())) {
            addCorrectBlockForUpperPath();
            return;
        }
        addCorrectBlockForLowerPath();
    }

    private void updateIncorrectBlock(String command) {
        if (command.equals(InputType.MOVE_UP_COMMAND.getCommand())) {
            addIncorrectBlockForUpperPath();
            return;
        }
        addIncorrectBlockForLowerPath();
    }

    private void addCorrectBlockForUpperPath() {
        upperPath += correctBlock;
        lowerPath += unselectedBlock;
    }

    private void addIncorrectBlockForUpperPath() {
        upperPath += incorrectBlock;
        lowerPath += unselectedBlock;
    }

    private void addCorrectBlockForLowerPath() {
        upperPath += unselectedBlock;
        lowerPath += correctBlock;
    }

    private void addIncorrectBlockForLowerPath() {
        upperPath += unselectedBlock;
        lowerPath += incorrectBlock;
    }
}
