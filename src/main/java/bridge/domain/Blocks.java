package bridge.domain;

import bridge.domain.enums.BlockStatus;
import bridge.domain.enums.CrossStatus;
import java.util.List;

public class Blocks {
    private final List<BlockStatus> blocks;

    public Blocks(final List<BlockStatus> blocks) {
        this.blocks = blocks;
    }

    public CrossStatus moveNextBlock(final String inputBlock, final CrossStatuses crossStatuses) {
        int uncrossedIndex = crossStatuses.findUncrossedIndex();
        return crossStatuses.updateStatus(selectBlock(uncrossedIndex, inputBlock), uncrossedIndex);
    }

    private CrossStatus selectBlock(final int uncrossedIndex, final String inputBlock) {
        BlockStatus blockStatus = blocks.get(uncrossedIndex);
        if (blockStatus.contains(inputBlock)) {
            return CrossStatus.SUCCESS;
        }
        return CrossStatus.FAIL;
    }
}
