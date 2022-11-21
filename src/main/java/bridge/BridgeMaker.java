package bridge;

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
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeLocation = bridgeNumberGenerator.generate();
            bridge.add(bridgeTypeMapToString(bridgeLocation));
        }
        return bridge;
    }

    /**
     * @param type 다리의 위치 타입
     * @return 입력받은 타입에 해당하는 문자열로 변환한 값. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     * @Exception IllegalArgumentException 현재 0과 1 이외의 값은 지원하지 않는다.
     */
    private String bridgeTypeMapToString(int type) {
        if (type == 0) return "D";
        if (type == 1) return "U";
        throw new IllegalArgumentException("지원 하지 않는 다리 위치 입니다.");
    }
}
