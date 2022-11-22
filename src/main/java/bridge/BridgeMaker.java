package bridge;

import bridge.ui.Constant;

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
            bridge.add(addBlock(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    /**
     * @param block 랜덤으로 생성된 1 or 0
     * @return block 값이 1이라면 "U", 0이라면 "D" 반환
     */
    private String addBlock(int block) {
        if (block == Constant.UP) {
            return "U";
        }
        else if (block == Constant.DOWN) {
            return "D";
        }
        throw new IllegalArgumentException();
    }
}
