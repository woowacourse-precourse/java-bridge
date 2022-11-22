package bridge;

import bridge.type.BridgeSideType;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * 메서드의 시그니처(인자, 이름)와 반환타입을 변경할 수 없다.
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

        for (int loopCount = 0; loopCount < size; loopCount++) {
            BridgeSideType bridgeStairs = BridgeSideType.getFindByNumber(bridgeNumberGenerator.generate());
            bridge.add(bridgeStairs.getSide());
        }
        return bridge;
    }
}
