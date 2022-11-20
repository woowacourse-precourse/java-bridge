package bridge.domain;

import bridge.domain.enums.BlockStatus;
import java.util.List;

public class Blocks {
    private final List<BlockStatus> blocks;

    public Blocks(final List<BlockStatus> blocks) {
        this.blocks = blocks;
    }
}
