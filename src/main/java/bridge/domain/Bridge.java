package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridgeBlocks;

    public Bridge(List<String> bridgeBlocks) {
        this.bridgeBlocks = bridgeBlocks;
    }

    public int getSize() {
        return bridgeBlocks.size();
    }

    public boolean isCrossable(int position, Direction direction) {
        String bridgeBlock = bridgeBlocks.get(position);
        String playerBlock = direction.getInitial();
        return bridgeBlock.equals(playerBlock);
    }
}
