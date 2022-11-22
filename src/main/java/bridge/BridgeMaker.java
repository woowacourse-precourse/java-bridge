package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {
    private static final String ERROR_FORMAT = "[ERROR] size는 %d ~ %d 이어야 합니다.";
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, MIN_SIZE, MAX_SIZE));
        }
        return IntStream.range(0, size)
                .mapToObj(it -> BlockPosition.from(bridgeNumberGenerator.generate()))
                .map(BlockPosition::toString)
                .collect(Collectors.toList());
    }
}
