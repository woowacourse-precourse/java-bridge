package bridge;

import bridge.enums.ControlKey;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    /**
     * 필드(인스턴스 변수) 변경 불가
     * 메서드의 인자, 이름, 반환타입 변경 불가
     * 패키지 이동 불가
     */

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
        for (int i = 0; i < size; i++) {
            String key = ControlKey.findKeyByBridgeNumber(bridgeNumberGenerator.generate());
            bridge.add(key);
        }
        return bridge;
    }
}
