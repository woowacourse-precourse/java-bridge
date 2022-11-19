package bridge;

import java.util.List;

public class Bridge {
    private final List<String> movableBlocks;

    public Bridge(List<String> movableBlocks) {
        this.movableBlocks = movableBlocks;
    }

    public boolean isMovableBlock(int position, String BlockInput) {
        return BlockInput.equals(movableBlocks.get(position));
    }
}
