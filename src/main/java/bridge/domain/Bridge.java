package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public void init(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getBlockByPlayerPosition(int position) {
        return bridge.get(position);
    }

    public BlockExpression getBlockExpressionByPosition(String bridgeBlock, boolean canMove) {
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
}
