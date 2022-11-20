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

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(parseBridgeNumber());
        }
        return bridge;
    }

    /**
     * 건널 수 있는 칸이 위 칸인지, 아래 칸인지 결정한다.
     * @return 랜덤으로 생성된 값이 0이면 "D"를, 1이면 "U"를 리턴한다.
     */
    private String parseBridgeNumber() {
        final String RANDOM_LOWER_INCLUSIVE = "D";
        final String RANDOM_UPPER_INCLUSIVE = "U";
        if (bridgeNumberGenerator.generate() == 0) {
            return RANDOM_LOWER_INCLUSIVE;
        }
        return RANDOM_UPPER_INCLUSIVE;
    }
}
