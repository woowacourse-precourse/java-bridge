package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final List<String> bridge = new ArrayList<>();
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        while (size > 0) {
            int block = this.bridgeNumberGenerator.generate();
            makeBlock(block);
            size--;
        }

        return this.bridge;
    }

    // 다리의 한 칸을 만듦
    private void makeBlock(int block) {
        if (block == Constants.BridgeStatus.DOWN.getStat()) {
            this.bridge.add(Constants.BridgeStatus.DOWN.getPos());
        }

        if (block == Constants.BridgeStatus.UPPER.getStat()) {
            this.bridge.add(Constants.BridgeStatus.UPPER.getPos());
        }
    }
}
