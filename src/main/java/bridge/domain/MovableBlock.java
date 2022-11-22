package bridge.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static bridge.util.Constant.MOVING_DOWN;
import static bridge.util.Constant.MOVING_UP;

public enum MovableBlock {
    UP(1, MOVING_UP),
    DOWN(0, MOVING_DOWN);

    private final int movableBlockInput;
    private final String movableBlock;

    private MovableBlock(int movableBlockInput, String movableBlock) {
        this.movableBlockInput = movableBlockInput;
        this.movableBlock = movableBlock;
    }

    public static String getMovableBlock(int movableBlockInput) {
        return Arrays.stream(MovableBlock.values())
                .filter(block -> block.movableBlockInput == (movableBlockInput))
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .movableBlock;
    }
}
