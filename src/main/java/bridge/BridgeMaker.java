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
        for (int i = 0; i < size; ++i) {
            int generatedValue = bridgeNumberGenerator.generate();
            String upOrDown = generatedNumberToMoving(generatedValue);
            bridge.add(upOrDown);
        }
        return List.copyOf(bridge);
    }

    /**
     * @param number 생성된 1 또는 0인 숫자
     * @return 1인지 0인지를 확인하여 "U" 또는 "D"를 반환한다.
     */
    private String generatedNumberToMoving(int number) {
        if (VerticalPositionValue.DOWN.getNumber().equals(number))
            return VerticalPositionValue.DOWN.getSign();
        return VerticalPositionValue.UP.getSign();
    }
}
