package bridge;

import java.util.List;

public class BridgePassed {
    private final List<String> blocks;
    private final boolean canMove;

    public BridgePassed(List<String> blocks, boolean canMove) {
        this.blocks = blocks;
        this.canMove = canMove;
    }

    public List<String> getBlocks() {
        return blocks;
    }

    public boolean canMove() {
        return canMove;
    }

    public int getBridgeSize() {
        return blocks.size();
    }

    public boolean compare(int index, String row) {
        return blocks.get(index).equals(row);
    }
}
