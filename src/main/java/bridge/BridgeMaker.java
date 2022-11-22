package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bridge.common.BridgeGameConstant.BRIDGE_MAX_LENGTH;
import static bridge.common.BridgeGameConstant.BRIDGE_MIN_LENGTH;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(final BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(final int size) {
        validate(size);
        return IntStream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .mapToObj(this::checkBridgeDirection)
                .collect(Collectors.toList());
    }

    private void validate(int size) {
        if (size > BRIDGE_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (size < BRIDGE_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private String checkBridgeDirection(final int key) {
        if (key == 1) {
            return "U";
        }
        return "D";
    }
}
