package bridge;

import java.util.ArrayList;
import java.util.Arrays;
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
        String bridgeNumber = generateBridgeNumber(size);
        return convertBridgeNumToChar(bridgeNumber);
    }

    private List<String> convertBridgeNumToChar(String bridgeNumber) {
        bridgeNumber = bridgeNumber.replace("0", "D");
        bridgeNumber = bridgeNumber.replace("1", "U");

        return Arrays.asList(bridgeNumber.split(""));
    }

    private String generateBridgeNumber(int size) {
        StringBuilder sb = new StringBuilder();
        for (int cnt = 0; cnt < size; cnt++)
            sb.append(bridgeNumberGenerator.generate());

        return sb.toString();
    }
}
