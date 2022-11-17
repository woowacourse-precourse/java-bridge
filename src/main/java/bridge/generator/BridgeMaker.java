package bridge.generator;

import bridge.BridgeNumberGenerator;

import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final static int up = 1;
    private final static int down = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        
        return null;
    }

    public String makeUpDown(int number) {
        String result = "";

        if(number == up) {
            result = "U";
        }

        if(number == down) {
            result = "D";
        }

        return result;
    }
}
