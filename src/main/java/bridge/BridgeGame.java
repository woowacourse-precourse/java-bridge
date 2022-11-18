package bridge;

import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    private List<String> realBridge;
    private HashMap<String, Integer> moveStatus;

    public void move(String direction) {
    }

    public void retry() {
    }
}
