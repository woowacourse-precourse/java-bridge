package bridge;

import static bridge.domain.BridgeGame.DOWN_BRIDGE;
import static bridge.domain.BridgeGame.UP_BRIDGE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    public static final int BRIDGE_SIZE_MIN_INCLUSIVE = 3;
    public static final int BRIDGE_SIZE_MAX_INCLUSIVE = 20;

    final int UP_BRIDGE_NUMBER = 1;
    final int DOWN_BRIDGE_NUMBER = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);

        return Stream.generate(bridgeNumberGenerator::generate)
                .map(this::turnBridgeNumberToBridgeSymbol)
                .limit(size)
                .collect(Collectors.toList());
    }

    private String turnBridgeNumberToBridgeSymbol(int bridgeNumber) {
        if (bridgeNumber == UP_BRIDGE_NUMBER) {
            return UP_BRIDGE;
        }

        if (bridgeNumber == DOWN_BRIDGE_NUMBER) {
            return DOWN_BRIDGE;
        }
        return null;
    }

    private void validateSize(int size) {
        if (BRIDGE_SIZE_MIN_INCLUSIVE > size || size > BRIDGE_SIZE_MAX_INCLUSIVE) {
            throw new IllegalArgumentException(
                    String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
                            BRIDGE_SIZE_MIN_INCLUSIVE,
                            BRIDGE_SIZE_MAX_INCLUSIVE));
        }
    }
}
