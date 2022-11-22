package bridge;

import static bridge.BlockStatus.*;

public class LastBlock implements Block {
    private final BlockPosition position;

    private BlockStatus blockStatus;

    public LastBlock(String position) {
        this.position = BlockPosition.from(position);
        this.blockStatus = BlockStatus.NOT_VISITED;
    }

    @Override
    public void visit(BlockPosition position) {
        if (blockStatus.isVisited()) {
            throw new IllegalStateException("[ERROR] 이미 지나갔습니다.");
        }

        if (this.position == position) {
            blockStatus = SUCCESS;
            return;
        }
        blockStatus = FAIL;
    }

    @Override
    public void reset() {
        this.blockStatus = NOT_VISITED;
    }

    @Override
    public Block next() {
        throw new IllegalStateException("[ERROR] 마지막 칸입니다.");
    }

    @Override
    public BlockPosition position() {
        return position;
    }

    @Override
    public boolean isVisited() {
        return blockStatus.isVisited();
    }

    @Override
    public boolean isLastBlock() {
        return true;
    }

    @Override
    public boolean isPassed() {
        return blockStatus.isPassed();
    }
}
