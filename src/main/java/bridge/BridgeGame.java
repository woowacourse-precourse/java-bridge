package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> userPath;

    public BridgeGame() {
        this.userPath = new ArrayList<String>();
    }

    public List<String> getUserPath() {
        return this.userPath;
    }

    public void move(String userPath) {
        this.userPath.add(userPath);
    }
    public void retry() {
        this.userPath.clear();
    }

    public int getBridgePosition() {
        return this.userPath.size()-1;
    }

    public boolean checkGameClear(Bridge bridge) {
        // 마지막이 같고 현재 다리 위치가 마지막이면 게임 clear
        return bridge.getLastBridge().equals(this.userPath.get(getBridgePosition())) &&
                getBridgePosition() == bridge.getBridge().size() - 1;
    }

}
