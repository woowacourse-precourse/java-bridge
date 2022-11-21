package bridge.domain;

import bridge.domain.enums.CrossStatus;

public class Bridge {
    private final Blocks blocks;
    private CrossStatuses crossStatuses;

    public Bridge(final Blocks blocks, CrossStatuses crossStatuses) {
        this.blocks = blocks;
        this.crossStatuses = crossStatuses;
    }

    public void moveNextBlock(final String inputBlock) {
        blocks.moveNextBlock(inputBlock, crossStatuses);
    }

    public MovingResult getMovingResult() {
        if (crossStatuses.isFail()) {
            return new MovingResult(blocks.getBlocks(), CrossStatus.FAIL, crossStatuses.findFailIndex());
        }
        return new MovingResult(blocks.getBlocks(), CrossStatus.SUCCESS, crossStatuses.findLastSuccessIndex());
    }

    public void clearCrossStatues() {
        crossStatuses = new CrossStatuses(CrossStatus.createInitializationStatuses(blocks.getSize()));
    }
}
