package bridge.domain.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeResult {

    private static final String CORRECT = "O";
    private static final String BLOCK_OF_UPSIDE = "U";
    private static final String BLOCK_OF_DOWNSIDE = "D";
    private static final String BLANK = " ";
    private static final int STARTING_INDEX_OF_BRIDGE = 0;
    private static final int LENGTH_OF_SEPARATOR = 3;

    private final List<String> upBlocks;
    private final List<String> downBlocks;

    public BridgeResult() {
        this.upBlocks = new ArrayList<>();
        this.downBlocks = new ArrayList<>();
    }

    public int countCorrectCrossing() {
        int count = 0;
        count += Collections.frequency(upBlocks, CORRECT);
        count += Collections.frequency(downBlocks, CORRECT);

        return count;
    }

    public void addBlock(String blockToMove, String correct) {
        if (blockToMove.equals(BLOCK_OF_UPSIDE)) {
            upBlocks.add(correct);
            downBlocks.add(BLANK);
        }
        if (blockToMove.equals(BLOCK_OF_DOWNSIDE)) {
            downBlocks.add(correct);
            upBlocks.add(BLANK);
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
        return bridge.substring(STARTING_INDEX_OF_BRIDGE, bridge.length() - LENGTH_OF_SEPARATOR) + " ]\n";
    }
}
