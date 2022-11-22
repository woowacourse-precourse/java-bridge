package bridge;

import bridge.util.validator.BridgeNumberValidator;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.constants.MovableSpace.UPPER_SPACE;
import static bridge.util.constants.MovableSpace.LOWER_SPACE;
import static bridge.util.constants.BridgeConstant.UPPER_BRIDGE_NUMBER;


/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * makeBridge 내부만 수정 가능
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
        List<String> bridge = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            addMovableSpace(bridge, bridgeNumber);
        }
        return bridge;
    }

    public void addMovableSpace(List<String> bridge, int bridgeNumber) {
        BridgeNumberValidator.validate(bridgeNumber);
        if (bridgeNumber == UPPER_BRIDGE_NUMBER.getValue()) {
            bridge.add(UPPER_SPACE.getValue());
            return;
        }
        bridge.add(LOWER_SPACE.getValue());
    }
}
