package bridge.domain;

import java.util.List;

public class Bridge {


    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getBridgeBlock(int position) {
        return bridge.get(position);
    }

    public int getSize() {
        return bridge.size();
    }


}
