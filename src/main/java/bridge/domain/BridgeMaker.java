package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final String UPPER_MOVING = "U";
    private static final String LOWER_MOVING = "D";
    private static final int UPPER_MOVING_NUMBER = 1;
    private static final int LOWER_MOVING_NUMBER = 0;

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

        while (bridge.size() != size) {
            bridge.add(convertNumberToMoving(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private String convertNumberToMoving(int number) {
        if (number == UPPER_MOVING_NUMBER) {
            return UPPER_MOVING;
        }
        return LOWER_MOVING;
    }
}
