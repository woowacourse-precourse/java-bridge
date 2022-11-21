package bridge;

import bridge.util.Constant;

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
        validate(size);
        List<String> bridge = new ArrayList<>();

        while (bridge.size() != size) {
            bridge.add(convertNumberToMoving(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private void validate(int size) {
        if (size < Constant.BRIDGE_MIN_SIZE || size > Constant.BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException("다리 길이는 3이상, 20이하의 크기만 가능합니다.");
        }
    }

    private String convertNumberToMoving(int number) {
        if (number == Constant.UPPER_MOVING_NUMBER) {
            return Constant.UPPER_MOVING;
        }
        return Constant.LOWER_MOVING;
    }
}
