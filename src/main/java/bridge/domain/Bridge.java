package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> blocks;

    public Bridge(List<String> blocks) {
        this.blocks = blocks;
    }

    public boolean isMoveSuccess(int round,
                                 String message) {
        return blocks.get(round).equals(message);
    }

    public boolean isGameClear(int round) {
        return blocks.size() == round;
    }
}
