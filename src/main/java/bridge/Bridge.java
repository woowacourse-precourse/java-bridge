package bridge;

import java.util.List;

public class Bridge {
    private final List<String> movableBlocks;

    public Bridge(List<String> movableBlocks) {
        validate(movableBlocks);
        this.movableBlocks = movableBlocks;
    }

    public boolean isMovableBlock(int position, String BlockInput) {
        return BlockInput.equals(movableBlocks.get(position));
    }

    private void validate(List<String> movableBlocks) {
        if (!movableBlocks.contains("D") && !movableBlocks.contains("U")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 문자가 포함되어 있습니다.");
        }
    }
}
