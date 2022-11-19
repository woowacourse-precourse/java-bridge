package bridge.domain.support;

import bridge.utils.MoveCommand;

import java.util.ArrayList;
import java.util.List;

import static bridge.utils.ErrorMessage.BRIDGE_OUT_OF_RANGE;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateBridgeSize(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int generate = bridgeNumberGenerator.generate();
            bridge.add(MoveCommand.of(generate));
        }

        return bridge;
    }

    private void validateBridgeSize(int size) {
        if (isOutOfRange(size)) {
            throw new IllegalArgumentException(BRIDGE_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int size) {
        return (size < MIN_BRIDGE_SIZE) || (size > MAX_BRIDGE_SIZE);
    }
}
