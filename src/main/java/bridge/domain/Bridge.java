package bridge.domain;

import java.util.Collections;
import java.util.List;

import static bridge.util.Constant.MOVING_DOWN;
import static bridge.util.Constant.MOVING_UP;

/**
 * 다리의 정보를 저장하는 클래스
 */
public class Bridge {
    private final List<String> movableBlocks;

    public Bridge(List<String> movableBlocks) {
        validate(movableBlocks);
        this.movableBlocks = movableBlocks;
    }

    public boolean isMovableBlock(int position, String BlockInput) {
        return BlockInput.equals(movableBlocks.get(position));
    }

    public List<String> getCrossedBridge(int position) {
        return movableBlocks.subList(0, position + 1);
    }

    public List<String> getMovableBlocks() {
        return Collections.unmodifiableList(this.movableBlocks);
    }

    private void validate(List<String> movableBlocks) {
        for (String block : movableBlocks) {
            if (!isValidBlock(block)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 문자가 포함되어 있습니다.");
            }
        }
    }

    private boolean isValidBlock(String block) {
        return block.equals(MOVING_UP) || block.equals(MOVING_DOWN);
    }
}
