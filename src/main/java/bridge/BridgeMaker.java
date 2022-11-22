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
        List<String> bridge = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            String state = convertNumberToString(randomNumber);
            bridge.add(state);
        }
        return bridge;
    }

    /**
     * @param number
     * @return 1 인 경우 "U", 0인 경우 "D" 를 반환 한다. 그 외의 경우 예외가 발생한다.
     */
    public String convertNumberToString(int number) {
        if (number == 1) {
            return "U";
        }
        if (number == 0) {
            return "D";
        }
        throw new IllegalArgumentException("[ERROR] : 0, 1 이외의 수");
    }
}
