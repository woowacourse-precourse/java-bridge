package bridge.model;

import java.util.Arrays;

public enum BlockStatus {
    O(true, " O "), X(false, " X "), UNSELECT(null, "   ");

    private final Boolean correct;
    private final String status;

    BlockStatus(Boolean correct, String status) {
        this.correct = correct;
        this.status = status;
    }

    public static BlockStatus of(boolean correct) {
        return Arrays.stream(BlockStatus.values())
                .filter(blockStatus -> blockStatus.correct != null)
                .filter(blockStatus -> blockStatus.correct.equals(correct))
                .findAny()
                .orElse(UNSELECT);
    }

    @Override
    public String toString() {
        return this.status;
    }
}
