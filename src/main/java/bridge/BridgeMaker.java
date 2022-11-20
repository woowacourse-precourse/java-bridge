package bridge;

import bridge.BridgeNumberGenerator;
import bridge.structure.BridgeMoveValue;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final String WARM = "[ERROR]";
    private final String WARM_BRIDGE_SIZE = WARM + " 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final int MIN_BRIDGE_SIZE = 3;
    private final int MAX_BRIDGE_SIZE = 20;
    private final int INITIAL_COUNT = 0;


    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);
        return generateBridge(size);
    }

    private void validateSize(int size) {
        if (size < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < size) {
            throw new IllegalArgumentException(WARM_BRIDGE_SIZE);
        }
    }

    private List<String> generateBridge(int size) {
        List<String> bridge = new ArrayList<>();
        int i = INITIAL_COUNT;
        while (i != size) {
            String stringIdentifier = BridgeMoveValue.generate(this.bridgeNumberGenerator.generate())
                    .getStringIdentifier();
            bridge.add(stringIdentifier);
            i++;
        }
        return bridge;
    }
}
