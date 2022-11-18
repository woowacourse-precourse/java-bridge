package bridge.domain;

import java.util.List;

public class Bridge {

    private final static int ROUND_VALUE_TO_BLOCKS_INDEX = 1;

    private final List<String> blocks;

    public Bridge(List<String> blocks) {
        this.blocks = blocks;
    }

    public boolean isMoveSuccess(int round,
                                 String message) {
        return blocks.get(round-ROUND_VALUE_TO_BLOCKS_INDEX).equals(message);
    }

    public boolean isGameClear(int round) {
        return blocks.size() == round;
    }
}
