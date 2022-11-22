package bridge;

import bridge.BridgeNumberGenerator;
import bridge.domain.FootrestLocation;
import java.util.ArrayList;
import java.util.List;

// TODO 주의! 필드(인스턴스 변수), 메서드의 시그니처(인자, 이름)와 반환 타입은 변경 불가능합니다

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
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (bridgeNumberGenerator.generate() == 0) {
                bridge.add(FootrestLocation.DOWN.getUserInput());
                continue;
            }
            bridge.add(FootrestLocation.UP.getUserInput());
        }
        return bridge;
    }
}
