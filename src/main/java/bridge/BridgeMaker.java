package bridge;

import bridge.domain.Move;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bridge.support.ErrorMessage.BRIDGE_MAKER_SIZE_ERROR;

public class BridgeMaker {

    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return Stream.generate(bridgeNumberGenerator::generate)
                .map(number -> Move.from(number).getCode())
                .limit(size)
                .collect(Collectors.toList());
    }

    public static void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < MINIMUM_BRIDGE_SIZE || MAXIMUM_BRIDGE_SIZE < bridgeSize) {
            throw new IllegalArgumentException(BRIDGE_MAKER_SIZE_ERROR);
        }
    }
}
