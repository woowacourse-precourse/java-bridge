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
     * 즉, 랜덤 인풋에서 1이면 U, 0이면 D로 표현한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        BridgeMakerUtil bridgeMakerUtil = new BridgeMakerUtil();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(bridgeMakerUtil.parseZeroOrOneToUorD(number));
        }
        return bridge;
    }
}