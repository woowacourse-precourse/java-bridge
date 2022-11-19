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

    public static BlockExpression getBlockExpressionByPosition(String bridgeBlock, boolean canMove) {
        if(canMove) {
            if(bridgeBlock.equals("U")) {
                return BlockExpression.MOVE_UP;
            }
            return BlockExpression.MOVE_DOWN;
        }
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
