package bridge;

import static bridge.domain.BridgeConstants.DOWN;
import static bridge.domain.BridgeConstants.UP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int UP_INPUT = 1;
    private static final int DOWN_INPUT = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>(size);
        for (int idx = 0; idx < size; idx++){
            bridge.add(bridgeValMapper(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private String bridgeValMapper(int pos){
        return Map.of(UP_INPUT, UP, DOWN_INPUT, DOWN).get(pos);
    }
}
