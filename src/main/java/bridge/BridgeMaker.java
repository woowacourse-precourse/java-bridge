package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static BridgeMaker bridgeMaker;
     List<String> bridge;

    public static BridgeMaker getInstance() {
        if (bridgeMaker == null) {
            bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        }
        return bridgeMaker;
    }
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<Integer> numList = bridgePlace(size);
        bridge = bridgeConvert(numList);
        return bridge;
    }

    public List<Integer> bridgePlace(int size) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int j = bridgeNumberGenerator.generate();
            numList.add(j);
        }
        return numList;
    }

    public List<String> bridgeConvert(List<Integer> bridge) {
        List<String> bridgeList = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            if (bridge.get(i) == 0) {
                bridgeList.add("D");
            }
            if (bridge.get(i) == 1) {
                bridgeList.add("U");
            }
        }
        return bridgeList;
    }
}
