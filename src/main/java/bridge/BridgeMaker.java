package bridge;

import bridge.domain.MovableBlock;

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

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int bridgeLength = 0; bridgeLength < size; bridgeLength++) {
            int movableBlock = bridgeNumberGenerator.generate();
            bridge.add(convertNumberToBridge(movableBlock));
        }
        return bridge;
    }

    private String convertNumberToBridge(int movableBlock) {
        return MovableBlock.getMovableBlock(movableBlock);
    }
}
