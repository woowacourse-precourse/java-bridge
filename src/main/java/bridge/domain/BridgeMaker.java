package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.Constants.BridgeSign.DOWN;
import static bridge.constant.Constants.BridgeSign.UP;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * <p>
 * 제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
 * BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다.
 * BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
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
        return generateBridgeList(size);
    }

    private List<String> generateBridgeList(int size) {
        List<String> bridge = new ArrayList<>();
        for (var i = 0; i < size; i++) {
            int direction = bridgeNumberGenerator.generate();
            if (direction == 1) {
                bridge.add(UP);
            } else if (direction == 0) {
                bridge.add(DOWN);
            }
        }
        return bridge;
    }

    private void validateBridgeSize(int size) {
        if (size >= 3 && size <= 20) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 다리 길이가 3이상 20이하 범위의 값이 아닙니다.");
    }
}
