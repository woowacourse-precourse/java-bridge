package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridgeBlocks;

    public Bridge(List<String> bridgeBlocks) {
        this.bridgeBlocks = bridgeBlocks;
    }

    public boolean isCrossable(int position, String block) {
        String bridgeBlock = bridgeBlocks.get(position);
        return bridgeBlock.equals(block);
    }
}
