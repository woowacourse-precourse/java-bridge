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

    private void validate(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이가 3에서 20사이의 수가 아닙니다.");
        }
    }

    private String convert(int random) {
        if (random == 0) {
            return "D";
        } else {
            return "U";
        }
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validate(size);

        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++){
            bridge.add(convert(bridgeNumberGenerator.generate()));
        }

        return bridge;
    }
}
