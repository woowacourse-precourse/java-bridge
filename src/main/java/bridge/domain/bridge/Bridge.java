package bridge.domain.bridge;

import bridge.BridgeMove;
import java.util.List;

public class Bridge {
    
    private final List<String> bridge;
    
    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }
    
    public int size() {
        return this.bridge.size();
    }
    
    public boolean canMoveToPosition(BridgeMove selectMove, int position) {
        return bridge.get(position).equals(selectMove.getDirection());
    }
}
