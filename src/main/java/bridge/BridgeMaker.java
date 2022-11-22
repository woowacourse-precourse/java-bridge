package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            bridge.add(mapSpace(bridgeNumberGenerator.generate()));
        }

        return bridge;
    }

    private String mapSpace(int number) {
        final int UP_NUMBER = 1;
        final int DOWN_NUMBER = 0;
        final String UP = "U";
        final String DOWN = "D";
        Map<Integer, String> mapping = new HashMap<>() {{
            put(UP_NUMBER, UP);
            put(DOWN_NUMBER, DOWN);
        }};

        return mapping.get(number);
    }
}
