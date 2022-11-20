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

    public void addStatus(BlockExpression expression) {
        this.upBlocks.add(expression.getUpBlock());
        this.downBlocks.add(expression.getDownBlock());
    }

    public List<String> getUpBlocks() {
        return this.upBlocks;
    }

    public List<String> getDownBlocks() {
        return this.downBlocks;
    }
}
