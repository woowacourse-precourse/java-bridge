package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final int MINIMUM_LENGTH = 3;
    private final int MAXIMUM_LENGTH = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) throws IllegalArgumentException {
        validateSize(size);
        List<String> bridge = new ArrayList<>();
        for (int i=0; i<size; i++) {
            bridge.add(mapToString(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private void validateSize(int size) throws IllegalArgumentException {
        if (size > MAXIMUM_LENGTH && size < MINIMUM_LENGTH) {
            //TODO : 에러메세지 구현
            throw new IllegalArgumentException();
        }
    }

    private String mapToString(int number) {
        if (number == 1) {
            return "U";
        }
        return "D";
    }
}
