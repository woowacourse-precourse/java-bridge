package bridge.domain;


import static bridge.domain.BridgeSize.MAX_SIZE;
import static bridge.domain.BridgeSize.MIN_SIZE;
import static bridge.domain.command.MoveCommand.MOVE_TO_LOWER_BLOCK;
import static bridge.domain.command.MoveCommand.MOVE_TO_UPPER_BLOCK;

import java.util.List;

public class Bridge {

    private final static int ROUND_VALUE_TO_BLOCKS_INDEX = 1;

    private final List<String> blocks;

    public Bridge(List<String> blocks) {
        validate(blocks);
        this.blocks = blocks;
    }

    public boolean isMoveSuccess(int round, String message) {
        return blocks.get(round-ROUND_VALUE_TO_BLOCKS_INDEX).equals(message);
    }

    public List<String> getBlocks() {
        return blocks;
    }

    private void validate(List<String> blocks) {
        if (isWrongSizeOfBlocks(blocks)) {
            throw new IllegalArgumentException();
        }

        if (containWrongValues(blocks)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isWrongSizeOfBlocks(List<String> blocks) {
        return blocks.size() < MIN_SIZE || blocks.size() > MAX_SIZE;

    }

    private boolean containWrongValues(List<String> blocks) {
        return blocks.stream()
                .anyMatch(value -> !value.equals(MOVE_TO_UPPER_BLOCK) && !value.equals(MOVE_TO_LOWER_BLOCK));
    }
}
