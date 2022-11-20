package bridge;

import static bridge.domain.BridgeInfo.BRIDGE_BOTTOM;
import static bridge.domain.BridgeInfo.BRIDGE_TOP;
import static bridge.utils.Constant.POOR_CONSTRUCTION;

import java.util.ArrayList;
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

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<Integer> bridgeNumbers = IntStream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .boxed()
                .collect(Collectors.toList());
        List<String> bridge = new ArrayList<>();
        for (Integer bridgeNumber : bridgeNumbers) {
            bridge.add(hardBridgePosition(bridgeNumber));
        }
        return bridge;
    }

    private String hardBridgePosition(int bridgeNumber) {
        if (bridgeNumber == BRIDGE_TOP.getBridgeNumber()) {
            return BRIDGE_TOP.getHardBridgePosition();
        }
        if (bridgeNumber == BRIDGE_BOTTOM.getBridgeNumber()) {
            return BRIDGE_BOTTOM.getHardBridgePosition();
        }
        return POOR_CONSTRUCTION;
    }
}
