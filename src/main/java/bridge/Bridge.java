package bridge;

import java.util.List;

public class Bridge {

    public static final String UP_BLOCK_MARK = "U";
    public static final String DOWN_BLOCK_MARK = "D";

    private final List<String> movableBlocks;

    public Bridge(List<String> movableBlocks) {
        this.movableBlocks = movableBlocks;
    }

    public boolean checkMoveResult(int position, String moveDirection) {
        String movableBlockAtPosition = movableBlocks.get(position);
        return movableBlockAtPosition.equals(moveDirection);
    }
}
