package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static List<String> bridgeIntegerMapper = Arrays.asList("D", "U"); //1일 때 위, 0일 때 밑

    private BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    private List<String> realBridge;
    private HashMap<String, List<Integer>> moveStatus;

    public BridgeGame(int bridgeLength) {
        realBridge = generateBridge(bridgeLength);
        moveStatus.put("U", new ArrayList<Integer>());
        moveStatus.put("D", new ArrayList<Integer>());
    }

    private List<String> generateBridge(int bridgeLength) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < bridgeLength; i++) {
            realBridge.add(bridgeIntegerMapper.get(numberGenerator.generate()));
        }

        return bridge;
    }
    public void move(String direction) {
    }

    public void retry() {
    }
}
