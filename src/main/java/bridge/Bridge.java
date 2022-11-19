package bridge;

import java.util.Arrays;
import java.util.List;

public class Bridge {
    private final List<String> blocks;

    public Bridge(List<String> blocks) {
        this.blocks = blocks;
    }

    public boolean isSizeEquals(int currentSize) {
        return currentSize == blocks.size();
    }

    public boolean isStepSuccess(String currentItem, int index) {
        return currentItem.equals(blocks.get(index));
    }

    public boolean compareBridgeWith(List<String> current) {
        return isSizeEquals(current.size()) && Arrays.equals(blocks.toArray(), current.toArray());
    }

}
