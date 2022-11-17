package bridge;

public class Path {
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
        upperPath += " O ]";
        lowerPath += "   ]";
    }

    private void addIncorrectBlockForUpperPath() {
        upperPath += " X ]";
        lowerPath += "   ]";
    }

    private void addCorrectBlockForLowerPath() {
        upperPath += "   ]";
        lowerPath += " O ]";
    }

    private void addIncorrectBlockForLowerPath() {
        upperPath += "   ]";
        lowerPath += " X ]";
    }
}
