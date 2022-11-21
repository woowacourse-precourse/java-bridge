package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeResult {
    private final List<String> upBlocks;
    private final List<String> downBlocks;

    public BridgeResult() {
        this.upBlocks = new ArrayList<>();
        this.downBlocks = new ArrayList<>();
    }

    public int countCorrectCrossing() {
        int count = 0;
        count += Collections.frequency(upBlocks, "O");
        count += Collections.frequency(downBlocks, "O");

        return count;
    }

    public void addBlock(String blockToMove, String correct) {
        //TODO: blockToMove에 대한 예외처리
        if (blockToMove.equals("U")) {
            upBlocks.add(correct);
            downBlocks.add(" ");
        }
        if (blockToMove.equals("D")) {
            downBlocks.add(correct);
            upBlocks.add(" ");
        }
    }

    public void clear() {
        upBlocks.clear();
        downBlocks.clear();
    }

    @Override
    public String toString() {
        return toBridgeString(upBlocks) + toBridgeString(downBlocks);
    }

    private String toBridgeString(List<String> blocks) {
        String bridge = "[ ";
        for (String block : blocks) {
            bridge += block + " | ";
        }
        return bridge.substring(0, bridge.length() - 3) + " ]\n";
    }
}
