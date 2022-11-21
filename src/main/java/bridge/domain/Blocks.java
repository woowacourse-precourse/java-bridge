package bridge.domain;

import bridge.domain.enums.BlockStatus;
import bridge.domain.enums.CrossStatus;
import java.util.List;

public class Blocks {
    private final List<BlockStatus> blocks;

    public Blocks(final List<BlockStatus> blocks) {
        this.blocks = blocks;
    }

    public void moveNextBlock(final String inputBlock, final CrossStatuses crossStatuses) {
        int uncrossedIndex = crossStatuses.findUncrossedIndex();
        crossStatuses.updateStatus(updateBlocks(uncrossedIndex, inputBlock), uncrossedIndex);
    }

    private CrossStatus updateBlocks(final int uncrossedIndex, final String inputBlock) {
        BlockStatus blockStatus = blocks.get(uncrossedIndex);
        if (blockStatus.contains(inputBlock)) {
            return CrossStatus.SUCCESS;
        }
        return CrossStatus.FAIL;
    }
}
