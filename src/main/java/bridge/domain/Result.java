package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<String> upBlocks;
    private final List<String> downBlocks;

    public Result() {
        upBlocks = new ArrayList<>();
        downBlocks = new ArrayList<>();
    }

    public void addBlocks(String upBlock, String downBlock) {
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
