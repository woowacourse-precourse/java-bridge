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
        for (int i = 0; i < size; i++) {        // 입력받은 수만큼 bridge를 만든다
            int randomNum=bridgeNumberGenerator.generate();
            if(randomNum == 1){        // randomNumber가 1이면 Up
                bridge.add("U");
            } if (randomNum == 0) {   // randomNumber가 0이면 Down
                bridge.add("D");
            }
        }
        return bridge;
    }
}
