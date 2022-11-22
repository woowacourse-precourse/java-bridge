package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bridge.config.BridgeGameConstants.BRIDGE_MAX_LENGTH;
import static bridge.config.BridgeGameConstants.BRIDGE_MIN_LENGTH;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public final class BridgeMaker {
    private static final String UNDER_SIZE_MESSAGE = "입력은 " + BRIDGE_MIN_LENGTH + "이상이어야 합니다";
    private static final String OVER_SIZE_MESSAGE = "입력은 " + BRIDGE_MAX_LENGTH + "이하여야 합니다";

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
        return IntStream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .mapToObj(this::toOneBridge)
                .collect(Collectors.toList());
    }

    private void validate(int size) {
        if (size > BRIDGE_MAX_LENGTH) {
            throw new IllegalArgumentException(OVER_SIZE_MESSAGE);
        }
        if (size < BRIDGE_MIN_LENGTH) {
            throw new IllegalArgumentException(UNDER_SIZE_MESSAGE);
        }
    }

    private String toOneBridge(int key) {
        if (key == 1) {
            return "U";
        }
        return "D";
    }
}
