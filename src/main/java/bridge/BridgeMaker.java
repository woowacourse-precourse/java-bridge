package bridge;

import bridge.constant.BridgeDirection;
import bridge.constant.BridgeSizeRule;
import bridge.constant.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

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
        validateBridgeSize(size);

        List<String> bridge = new ArrayList<>();
        for (int quantityMade = 0; quantityMade < size; quantityMade++) {
            int integerDirection = bridgeNumberGenerator.generate();
            bridge.add(BridgeDirection.convertToString(integerDirection));
        }
        return bridge;
    }

    private void validateBridgeSize(Integer size) {
        if (!(BridgeSizeRule.MINIMUM_SIZE.getSize() <= size && size <= BridgeSizeRule.MAXIMUM_SIZE.getSize())) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_MUST_BE_FROM_THREE_TO_TWENTY.getMessage());
        }
    }
}
