package bridge.domain;

import bridge.domain.enums.BlockStatus;
import bridge.domain.enums.CrossStatus;
import java.util.List;

public class Bridge {
    private final List<BlockStatus> blocks;
    private final List<CrossStatus> crossStatuses;

    public Bridge(final List<BlockStatus> blocks) {
        this.blocks = blocks;
        this.crossStatuses = CrossStatus.createInitializationStatuses(blocks.size());
    }
}
