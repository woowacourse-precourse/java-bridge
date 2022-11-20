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

}
