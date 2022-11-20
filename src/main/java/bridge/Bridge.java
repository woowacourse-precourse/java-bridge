package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    private String getCorrectPosition(int bridgePosition) {
        if (this.bridge.size() <= bridgePosition) {
            throw new IndexOutOfBoundsException("[ERROR} 다리에 접근할 수 없는 bridgePosition");
        }
        return this.bridge.get(bridgePosition);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userPosition, int bridgePosition) {
        return getCorrectPosition(bridgePosition).equals(userPosition);
    }

    public boolean checkClear(boolean canMove, int bridgePosition) {
        return canMove && (this.bridge.size()-1 == bridgePosition);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(UserPath userPath) {
        userPath.clearPath();
    }
