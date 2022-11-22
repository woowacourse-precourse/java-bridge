package bridge;

import static bridge.BlockStatus.*;

public class NormalBlock implements Block {
    private final BlockPosition position;

    private BlockStatus blockStatus;

    private Block next;

    private NormalBlock(String position) {
        this.position = BlockPosition.from(position);
        this.blockStatus = NOT_VISITED;
    }

    public static NormalBlock firstBlock(String position) {
        return new NormalBlock(position);
    }

    public NormalBlock nextBlock(String position) {
        this.next = new NormalBlock(position);
        return (NormalBlock) next;
    }

    public LastBlock lastBlock(String position) {
        this.next = new LastBlock(position);
        return (LastBlock) next;
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
        return next;
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
        return false;
    }

    @Override
    public boolean isPassed() {
        return blockStatus == SUCCESS;
    }
}
