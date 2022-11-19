package bridge.maker;

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
     * @return 입력받은 길이에 해당하는 다리 모양 (U : 위 칸, D : 아래 칸)
     */
    public List<String> makeBridge(int size) {
        List<String> randomBridge = new ArrayList<>();

        for(int i = 0; i < size; i++){
            int randBridgeNumber = bridgeNumberGenerator.generate();

            randomBridge.add(convertBridgeNumberToString(randBridgeNumber));
        }

        return randomBridge;
    }

    /**
     * @return 입력된 다리 정수를 문자열로 반환. 0이면 "D", 1이면 "U"으로 반환한다.
     */
    private String convertBridgeNumberToString(int randBridgeNumber) {
        if(randBridgeNumber == 0)
            return "D";
        return "U";
    }
}
