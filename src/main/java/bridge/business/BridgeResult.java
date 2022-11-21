package bridge.business;

import bridge.enumeration.MovingKey;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private final BridgeGame bridgeGame;

    private int tryCount;
    private boolean success;
    private List<String> bridge;

    public BridgeResult(BridgeGame bridgeGame){
        this.tryCount = 0;
        this.success = true;
        this.bridge = new ArrayList<>();
        this.bridgeGame = bridgeGame;
    }
    public void move(String movingKey) throws IndexOutOfBoundsException, IllegalArgumentException {
        validateMovingKey(movingKey);

        bridge.add(movingKey);
        int lastIndex = bridge.size()-1;
        this.success = bridgeGame.move(movingKey, lastIndex);
    }

    public void refresh() {
        tryCount++;
        success = true;
        bridge.clear();
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<String> getBridge() {
        return bridge;
    }

    private void validateMovingKey(String movingKey) {
        if(movingKey.equals(MovingKey.UP.getKey())){
            return;
        }
        if(movingKey.equals(MovingKey.DOWN.getKey())){
            return;
        }
        throw new IllegalArgumentException("올바르지 못한 이동 키 입니다.");
    }
}
