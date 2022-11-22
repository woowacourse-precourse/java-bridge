package bridge;

import bridge.enums.InputConstants;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * 필드 변경 불가능
 * 매서드 시그니쳐, 반환타입 변경 불가
 */
public class BridgeMaker {

    private static final int UP_MOVE_NUMBER = 1;

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
        for (int blockIndex = 0; blockIndex < size; blockIndex++) {

            if (bridgeNumberGenerator.generate() == UP_MOVE_NUMBER) {
                bridge.add(InputConstants.UP_MOVE.getValue());
                continue;
            }
            bridge.add(InputConstants.DOWN_MOVE.getValue());
        }
        return bridge;
    }

}
