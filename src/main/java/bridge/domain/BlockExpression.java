package bridge.domain;

public enum BlockExpression {
    MOVE_UP("O", " "),
    MOVE_DOWN(" ", "O"),
    NOT_MOVE_UP(" ", "X"),
    NOT_MOVE_DOWN("X", " ");

    private String upBlock;
    private String downBlock;

    BlockExpression(String upBlock, String downBlock) {
        this.upBlock = upBlock;
        this.downBlock = downBlock;
    }

    public String getUpBlock() {
        return upBlock;
    }

    public String getDownBlock() {
        return downBlock;
    }
}
