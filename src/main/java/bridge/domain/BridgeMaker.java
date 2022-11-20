package bridge.domain;

import bridge.BridgeNumberGenerator;

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
        List<String> output = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            output.add(getBridgeLaneText(bridgeNumber));
        }
        return output;
    }

    private String getBridgeLaneText(int number) {
        if(number == 0) {
            return "D";
        }
        if(number == 1) {
            return "U";
        }
        throw new IllegalArgumentException("다리를 생성할 때는 1 혹은 0의 숫자 중 하나를 이용해 생성합니다.");
    }
}
