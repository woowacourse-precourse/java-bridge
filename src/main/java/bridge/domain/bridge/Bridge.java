package bridge.domain.bridge;

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
        validatePosition(position);
        return bridge.get(position).equals(selectMove.getDirection());
    }
    
    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("다리 위치는 0보다 작을 수 없습니다.");
        }
        
        if (position > size() - 1) {
            throw new IllegalArgumentException("다리 길이보다 큰 위치로 이동할 수 없습니다.");
        }
    }
}
