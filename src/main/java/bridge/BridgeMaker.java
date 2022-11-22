package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Application.ERROR_PREFIX;

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
        validate(size);
        List<String> bridge = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            bridge.add(getBridgeElement());
        }
        return bridge;
    }

    private String getBridgeElement() {
        int random = bridgeNumberGenerator.generate();
        if (random == 0) {
            return "D";
        }
        if (random == 1) {
            return "U";
        }
        throw new IllegalArgumentException();
    }

    private void validate(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ERROR_PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
