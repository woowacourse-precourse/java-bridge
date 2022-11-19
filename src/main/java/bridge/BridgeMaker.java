package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public static BridgeMaker getInstanceByRandomGenerator() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>(size);

        for (int bridgeLengthCount = 0; bridgeLengthCount < size; bridgeLengthCount++) {
            bridge.add(generateBridgeLine());
        }
        return List.copyOf(bridge);
    }

    private String generateBridgeLine() {
        int number = bridgeNumberGenerator.generate();

        if (number == 0) {
            return GameKeySet.DOWN.getKeySet();
        }
        if (number == 1) {
            return GameKeySet.UP.getKeySet();
        }

        throw new IllegalStateException("[ERROR] 랜덤 생성 오류");
    }
}
