package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> blocks;

    public Bridge(List<String> blocks) {
        this.blocks = blocks;
    }

    public int length() {
        return this.blocks.size();
    }

    public String findByIndex(int index) {
        return blocks.get(index);
    }
}
