package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final String GENERATOR_ERROR = "[ERROR] 랜덤 생성기가 제대로 작동하지 않습니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";

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
            bridge.add(createRandomNumber());
        }
        return bridge;
    }

    public String createRandomNumber() {
        int randomNumber = bridgeNumberGenerator.generate();
        if (randomNumber == 1) {
            return UP;
        }
        if (randomNumber == 0) {
            return DOWN;
        }
        throw new IllegalArgumentException(GENERATOR_ERROR);
    }
}
