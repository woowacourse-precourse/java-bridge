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
        validateNumberRange(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(isUpOrDown(number));
        }
        return bridge;
    }

    private void validateNumberRange(int number) {
        if (number < Input.MIN_VALUE.toInteger() || number > Input.MAX_VALUE.toInteger()) {
            throw new IllegalArgumentException(Error.OUT_OF_RANGE.toString());
        }
    }

    private String isUpOrDown(int number) {
        if (number == Input.DOWN.toInteger()) {
            return Input.DOWN.toString();
        }
        if (number == Input.UP.toInteger()) {
            return Input.UP.toString();
        }
        throw new IllegalArgumentException(Error.U_OR_D.toString());
    }
}
