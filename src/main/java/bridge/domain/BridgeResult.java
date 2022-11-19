package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private final List<String> upBlocks;
    private final List<String> downBlocks;

    public BridgeResult() {
        this.upBlocks = new ArrayList<>();
        this.downBlocks = new ArrayList<>();
    }

    public void addBlock(String blockToMove, String correct) {
        if (blockToMove.equals("U")) {
            upBlocks.add(correct);
            downBlocks.add(" ");
        }
        if (blockToMove.equals("D")) {
            downBlocks.add(correct);
            upBlocks.add(" ");
        }
    }

    public void clearBridge() {
        upBlocks.clear();
        downBlocks.clear();
    }
}
