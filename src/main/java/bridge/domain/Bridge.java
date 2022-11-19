package bridge.domain;

import bridge.domain.enums.CrossStatus;
import java.util.List;

public class Bridge {
    private final List<String> blocks;
    private final List<CrossStatus> crossStatuses;

    public Bridge(final List<String> blocks) {
        this.blocks = blocks;
        this.crossStatuses = CrossStatus.createInitializationStatuses(blocks.size());
    }
}
