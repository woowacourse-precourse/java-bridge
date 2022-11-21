package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.Constants.*;
import static bridge.domain.exception.ErrorMessage.*;

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
        validateBrideSize(size);
        List<String> bridge = new ArrayList<>();
        return addBridgeArrow(bridge, size);
    }

    private void validateBrideSize(int size) {
        if (size < BRIDGE_SIZE_LOWER_INCLUSIVE || size > BRIDGE_SIZE_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE);
        }
    }

    private List<String> addBridgeArrow(List<String> bridge, int size) {
        while (size-- > 0) {
            int bridgeRandomNumber = bridgeNumberGenerator.generate();
            bridge.add(convertBridgeRandomNumberToUpDownMark(bridgeRandomNumber));
        }
        return bridge;
    }

    private String convertBridgeRandomNumberToUpDownMark(int bridgeRandomNumber) {
        if (bridgeRandomNumber == BRIDGE_DOWN_NUMBER) {
            return DOWN;
        }
        return UP;
    }
}
