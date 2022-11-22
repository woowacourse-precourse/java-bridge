package bridge.domain;

import java.util.List;

public class Bridge {
    List<String> bridgeBlocks;

    public Bridge(List<String> bridgeBlocks) {
        this.bridgeBlocks = bridgeBlocks;
    }

    public boolean matchBlockLocation(int location, String block) {
        return (bridgeBlocks.get(location).equals(block));
    }

    public boolean hasNextBlock(int playerLocation) {
        if ((bridgeBlocks.size() - 1) > playerLocation) {
            return true;
        }
        return false;
    }
}
