package bridge.domain;

public enum BlockExpression {
    MOVE_UP("O", " "),
    MOVE_DOWN(" ", "O"),
    NOT_MOVE_UP(" ", "X"),
    NOT_MOVE_DOWN("X", " ");

    private final String upBlock;
    private final String downBlock;

    BlockExpression(String upBlock, String downBlock) {
        this.upBlock = upBlock;
        this.downBlock = downBlock;
    }

    public static BlockExpression getBlockExpressionByMove(boolean isUpBlock) {
        return getBlockExpression(isUpBlock, MOVE_UP, MOVE_DOWN);
    }

    public static BlockExpression getBlockExpressionByNotMove(boolean isUpBlock) {
        return getBlockExpression(isUpBlock, NOT_MOVE_UP, NOT_MOVE_DOWN);
    }

    private static BlockExpression getBlockExpression(boolean isUpBlock,
                                                      BlockExpression expression1,
                                                      BlockExpression expression2) {
        if (isUpBlock) {
            return expression1;
        }
        return expression2;
    }

    public String getUpBlock() {
        return upBlock;
    }

    public String getDownBlock() {
        return downBlock;
    }
}
