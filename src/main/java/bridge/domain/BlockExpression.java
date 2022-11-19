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

    public static BlockExpression getBlockExpressionByMove(String bridgeBlock) {
        if(bridgeBlock.equals("U")) {
            return BlockExpression.MOVE_UP;
        }
        return BlockExpression.MOVE_DOWN;
    }

    public static BlockExpression getBlockExpressionByNotMove(String bridgeBlock) {
        if(bridgeBlock.equals("U")) {
            return BlockExpression.NOT_MOVE_UP;
        }
        return BlockExpression.NOT_MOVE_DOWN;
    }

    public String getUpBlock() {
        return upBlock;
    }

    public String getDownBlock() {
        return downBlock;
    }
}
