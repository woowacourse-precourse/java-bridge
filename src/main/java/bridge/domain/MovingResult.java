package bridge.domain;

import bridge.domain.enums.BlockStatus;
import bridge.domain.enums.CrossStatus;
import bridge.generators.MessageGenerator;
import java.util.Collections;
import java.util.List;

public class MovingResult {
    private final List<BlockStatus> blocks;
    private final CrossStatus movingResultStatus;
    private final int currentMovedIndex;

    public MovingResult(final List<BlockStatus> blocks, final CrossStatus movingResultStatus,
                        final int currentMovedIndex) {
        this.blocks = blocks;
        this.movingResultStatus = movingResultStatus;
        this.currentMovedIndex = currentMovedIndex;
    }

    public boolean isFailToMove() {
        return movingResultStatus == CrossStatus.FAIL;
    }

    public List<BlockStatus> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }

    public int getCurrentMovedIndex() {
        return currentMovedIndex;
    }

    public CrossStatus getMovingResultStatus() {
        return movingResultStatus;
    }

    public String getLastMoveResult(final BlockStatus expectedStatus) {
        if (movingResultStatus == CrossStatus.SUCCESS && blocks.get(currentMovedIndex) == expectedStatus) {
            return MessageGenerator.CORRECT;
        }
        if (movingResultStatus == CrossStatus.FAIL && blocks.get(currentMovedIndex) != expectedStatus) {
            return MessageGenerator.WRONG;
        }
        return MessageGenerator.NO_SELECT;
    }

    public boolean isFinish() {
        return blocks.size() == currentMovedIndex + 1;
    }
}
