package bridge;

import static bridge.Validator.validateBridgeRandomNum;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeRandomNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeRandomNumberGenerator) {
        this.bridgeRandomNumberGenerator = bridgeRandomNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList <>();
        for (int i = 0 ; i < size ; i++) {
            bridge.add(convertBridgeNumber(bridgeRandomNumberGenerator.generate()));
        }
        return bridge;
    }

    public String convertBridgeNumber(int randomNum) {
        validateBridgeRandomNum(randomNum);
        if (randomNum == 0) return "D";
        if (randomNum == 1) return "U";
        return null;
    }
}
