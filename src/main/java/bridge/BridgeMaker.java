package bridge;

import data.BridgeData;
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
        int bridgePiece;
        for (int sizeCount = 0; sizeCount < size; sizeCount++) {
            bridgePiece = bridgeNumberGenerator.generate();
            bridge.add(makeBridgePiece(bridgePiece));
        }

        return bridge;
    }

    public String makeBridgePiece(int bridgePiece) {
        if (bridgePiece == 0) {
            return BridgeData.DOWN;
        }
        return BridgeData.UP;
    }
}
