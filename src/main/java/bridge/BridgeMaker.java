package bridge;

import static bridge.domain.command.MoveCommand.LOWER_BLOCK;
import static bridge.domain.command.MoveCommand.UPPER_BLOCK;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    
    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(idx -> getBridgeBlock())
                .collect(Collectors.toList());
    }

    private String getBridgeBlock() {
        if (bridgeNumberGenerator.generate() == 1) {
            return UPPER_BLOCK;
        }
        return LOWER_BLOCK;
    }
}
