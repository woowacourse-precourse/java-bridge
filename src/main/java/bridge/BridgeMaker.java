package bridge;

import bridge.domain.enums.BlockStatus;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> numberBlocks = Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .collect(Collectors.toList());
        return BlockStatus.createSymbolBlocks(numberBlocks);
    }
}
