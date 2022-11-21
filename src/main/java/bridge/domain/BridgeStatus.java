package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeStatus {
    private final List<String> upBlocks;
    private final List<String> downBlocks;

    public BridgeStatus() {
        this.upBlocks = new ArrayList<>();
        this.downBlocks = new ArrayList<>();
    }

    public void addStatus(String upBlock, String downBlock) {
        this.upBlocks.add(upBlock);
        this.downBlocks.add(downBlock);
    }

    public List<String> getUpBlocks() {
        return this.upBlocks;
    }

    public List<String> getDownBlocks() {
        return this.downBlocks;
    }
}
