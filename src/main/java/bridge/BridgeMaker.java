package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Error.BRIDGE_NUMBER_ERROR;

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
            int number = bridgeNumberGenerator.generate();
            if (number != 0 && number != 1) {
                throw new IllegalArgumentException(BRIDGE_NUMBER_ERROR.getMessage());
            }
            bridge.add(numberToString(number));
        }
        return bridge;
    }

    private String numberToString(int number) {
        if (number == 0) {
            return "D";
        }
        return "U";
    }
}
