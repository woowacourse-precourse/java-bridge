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
    private int currentLocation;

    public BridgeGame(int bridgeLength) {
        realBridge = generateBridge(bridgeLength);
        moveStatus.put("U", new ArrayList<Integer>());
        moveStatus.put("D", new ArrayList<Integer>());
        currentLocation = 0;
    }

    private List<String> generateBridge(int bridgeLength) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < bridgeLength; i++) {
            realBridge.add(bridgeIntegerMapper.get(numberGenerator.generate()));
        }

        return bridge;
    }
    public boolean move(String direction) {
        //방향이 맞는지 검증하고,
        //그렇다면 moveStatus 에 O 추가하고 return true
        //그렇지 않다면 moveStatus에 X 추가하고 return false

        if (realBridge.get(currentLocation) == direction) {
            return reflectMovement(true);
        }
        return reflectMovement(false);
    }

    public void retry() {
    }
}
