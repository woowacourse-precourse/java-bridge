package bridge.domain;

import static bridge.messages.ErrorMessage.OUTBOUND_BRIDGE_SIZE_ERROR;

import bridge.domain.enums.BlockStatus;
import java.util.List;

public class Blocks {
    private static final int MINIMUM_SIZE = 3;
    private static final int MAXIMUM_SIZE = 20;

    private final List<BlockStatus> blocks;

    public Blocks(final List<BlockStatus> blocks) {
        validate(blocks);
        this.blocks = blocks;
    }

    private void validate(final List<BlockStatus> blocks) {
        if (blocks.size() < MINIMUM_SIZE || blocks.size() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(OUTBOUND_BRIDGE_SIZE_ERROR);
        }
    }
}
