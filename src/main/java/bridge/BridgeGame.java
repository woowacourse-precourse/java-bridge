package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    private List<String> realBridge;
    private HashMap<String, List<Integer>> moveStatus;

    public BridgeGame(int bridgeLength) {
        realBridge = generateBridge(bridgeLength);
        moveStatus.put("U", new ArrayList<Integer>());
        moveStatus.put("D", new ArrayList<Integer>());
    }
    public void move(String direction) {
    }

    public void retry() {
    }
}
