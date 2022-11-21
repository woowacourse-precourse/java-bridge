package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bridge.utils.constant.Constants.*;

import bridge.domain.BridgeBlock;

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
        return IntStream.range(START_INCLUSIVE, size)
                .mapToObj(block -> makeBridgeBlock())
                .collect(Collectors.toList());
    }

    public String makeBridgeBlock() {
        int bridgeNumber = bridgeNumberGenerator.generate();
        return BridgeBlock.getBridgeBlock(bridgeNumber);
    }

}
