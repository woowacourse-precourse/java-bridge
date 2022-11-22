package bridge;

import bridge.constant.Moving;

import java.util.ArrayList;
import java.util.List;

// 필드(인스턴스 변수) 변경 불가
// 메서드의 시그니처(인자, 이름)와 반환 타입 변경 불가
// 다리 칸을 생성하기 위한 Random 값 추출은 int number = bridgeNumberGenerator.generate(); 사용

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
            int number = bridgeNumberGenerator.generate();
            bridge.add(toKey(number));
        }
        return bridge;
    }

    private String toKey(int number) {
        if (number == 1)
            return Moving.UP.getKey();
        if (number == 0)
            return Moving.DOWN.getKey();
        return null;
    }
}
