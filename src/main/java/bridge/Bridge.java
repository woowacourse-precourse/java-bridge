package bridge;

import java.util.List;

public class Bridge {

    public static final String UP_BLOCK_MARK = "U";
    public static final String DOWN_BLOCK_MARK = "D";

    private final List<String> movableBlocks;

    public Bridge(List<String> movableBlocks) {
        this.movableBlocks = movableBlocks;
    }

    public boolean determineMoveResult(int position, String moveDirection) {
        return movableBlocks.get(position).equals(moveDirection);
    }

    public boolean isEndOfBridge(int currentPosition) {
        return movableBlocks.size() - 1 == currentPosition;
    }
}
