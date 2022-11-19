package bridge;

import bridge.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
 BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다.
 BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
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
            bridge.add(translate(bridgeNumberGenerator.generate()));
        }

        return bridge;
    }

    private String translate(Integer randomNumber) {
        Map<Integer, String> translationRule = new HashMap<>();

        for (Direction direction : Direction.values()) {
            translationRule.put(direction.getCode(), direction.getAbbr());
        }

        return translationRule.get(randomNumber);
    }
}
