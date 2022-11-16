package bridge;

import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateLength(size);
        return null;
    }

    private void validateLength(int length) {
        if (length < MIN_BRIDGE_LENGTH || MAX_BRIDGE_LENGTH < length) {
            throw new IllegalArgumentException("다리의 길이는 3 이상 20 이하의 값만 입력 가능합니다.");
        }
    }
}
