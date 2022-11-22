package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양 (U : 위 칸, D : 아래 칸)
     */
    public List<String> makeBridge(int size) {
        List<String> randomBridge = new ArrayList<>();
        Map<Integer, String> convertIntToString = new TreeMap<>(); // 랜덤으로 생성된 숫자를 문자로 바꿔주는 Map

        convertIntToString.put(0, "D");
        convertIntToString.put(1, "U");

        for(int i = 0; i < size; i++)
            randomBridge.add(convertIntToString.get(bridgeNumberGenerator.generate()));

        return randomBridge;
    }
}
