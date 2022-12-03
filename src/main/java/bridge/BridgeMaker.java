package bridge;


import bridge.BridgeNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bridge.utils.ErrorMessage.INVALID_BRIDGE_SIZE;
import static bridge.utils.ErrorMessage.WRONG_IN_MAKE_BRIDGE;

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
        validateBridgeSize(size);
        return Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .map(this::convertToDirection)
                .collect(Collectors.toList());
    }

    private String convertToDirection(int number) {
        validateGeneratedNumber(number);
        if (number == 1) {
            return "U";
        }
        return "D";
    }

    private void validateGeneratedNumber(int number) {
        if (number != 1 && number != 0) {
            throw new IllegalStateException(WRONG_IN_MAKE_BRIDGE.message);
        }
    }

    private void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.message);
        }
    }
}
