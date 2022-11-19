package bridge;

import bridge.utils.Pass;
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
        validateBridgeSize(size);

        return getPassableBridge(size);
    }

    private List<String> getPassableBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int index = 0; index < size; index++) {
            int number = bridgeNumberGenerator.generate();

            bridge.add(getPassableText(number));
        }
        return bridge;
    }

    private String getPassableText(int number) {
        return Pass.getPassableByNumber(number);
    }

    private void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("다리의 길이는 3 ~ 20이어야 합니다");
        }
    }
}
