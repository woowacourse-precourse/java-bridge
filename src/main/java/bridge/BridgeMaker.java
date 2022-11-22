package bridge;

import static bridge.domain.vo.MoveCommand.MOVE_TO_LOWER_BLOCK;
import static bridge.domain.vo.MoveCommand.MOVE_TO_UPPER_BLOCK;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int generateValue = bridgeNumberGenerator.generate();
        if (generateValue == 1) {
            return MOVE_TO_UPPER_BLOCK;
        }
        if (generateValue == 0) {
            return MOVE_TO_LOWER_BLOCK;
        }

        throw new IllegalArgumentException("NumberGenerator가 잘못된 값을 전달합니다. 입력값 : " + generateValue);
    }
}
