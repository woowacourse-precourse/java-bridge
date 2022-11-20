package bridge.domain;

import bridge.domain.enums.BlockStatus;
import bridge.domain.enums.CrossStatus;
import java.util.List;

public class Bridge {
    private final Blocks blocks;
    private final CrossStatuses crossStatuses;

    public Bridge(final List<BlockStatus> blocks) {
        this.blocks = new Blocks(blocks);
        this.crossStatuses = CrossStatus.createInitializationStatuses(blocks.size());
    }
}
