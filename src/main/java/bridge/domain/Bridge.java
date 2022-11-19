package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public void init(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getBlockByPlayerPosition(int position) {
        return bridge.get(position);
    }

    public boolean isDoneCrossingBridge(int position) {
        return position == bridge.size();
    }
}
