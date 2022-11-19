package bridge;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MovableBlock {
    UP(1,"U"),
    DOWN(0, "D");

    private int movableBlockInput;
    private String movableBlock;

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
