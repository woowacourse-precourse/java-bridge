package bridge.util;

import static bridge.ExceptionConst.*;

import bridge.domain.UpDownFlag;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int MINIMUM_BRIDGE_LENGTH = 3;
    private static final int MAXIMUM_BRIDGE_LENGTH = 20;

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
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(createRandomUpDown());
        }
        return bridge;
    }

    private String createRandomUpDown() {
        int zeroOrOne = bridgeNumberGenerator.generate();
        return UpDownFlag.codeToFlag(zeroOrOne);
    }

    private void validateLength(int size) {
        if (size < MINIMUM_BRIDGE_LENGTH || size > MAXIMUM_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_BRIDGE_LENGTH_3_TO_20);
        }
    }
}
