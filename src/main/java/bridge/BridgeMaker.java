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

        for (int i = 0; i < size; i++) {
            bridge.add(numberToStringConvert());
        }

        return bridge;
    }

    /**
     * @return bridgeNumberGenerator 에서 생성한 번호가 <p>0이라면 "D" <p>1이라면 "U" 반환한다.
     */
    private String numberToStringConvert() {
        // 0또는 1번호 생성
        int number = bridgeNumberGenerator.generate();

        if (number == 0) {
            return "D";
        }
        if (number == 1) {
            return "U";
        }

        throw new IllegalArgumentException("[ERROR] 랜덤으로 생성되어야 하는 번호는 0또는 1이여야 합니다.");
    }
}
