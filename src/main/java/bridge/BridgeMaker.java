package bridge;

import bridge.constant.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

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

        return Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .map(Moving::convertToDirection)
                .collect(Collectors.toList());
    }

    private void validate(int size) {
        if (isInvalidRange(size)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE_RANGE);
        }
    }

    private static boolean isInvalidRange(int size) {
        return size < MIN_SIZE || size > MAX_SIZE;
    }
}
