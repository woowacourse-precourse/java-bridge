package bridge;

import bridge.BridgeNumberGenerator;
import bridge.message.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final String TOP = "U";
    private static final String BOTTOM = "D";

    /**
     * 필드 변경 불가 (* 추가는 가능하다는 것인가?) 함수의 파라미터 및 반환 값 변경 불가
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
            bridge.add(makePassable());
        }
        return bridge;
    }

    private String makePassable() {
        int passable = bridgeNumberGenerator.generate();
        if (passable == 1) {
            return TOP;
        }
        if (passable == 0) {
            return BOTTOM;
        }
        throw new IllegalArgumentException(ErrorMessage.UNEXPECTED_ERROR);
    }
}
