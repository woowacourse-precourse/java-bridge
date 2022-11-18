package bridge.domain;

import java.util.List;

import static bridge.domain.Constants.*;

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
        return null;
    }

    private void validateBrideSize(int size) {
        if (size < BRIDGE_SIZE_LOWER_INCLUSIVE || size > BRIDGE_SIZE_LOWER_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
    }
}
