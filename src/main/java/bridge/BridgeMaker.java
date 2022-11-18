package bridge;

import bridge.util.BridgeGameInfo;

import java.util.ArrayList;
import java.util.List;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int count = 0; count < size; count++) {
            String bridgePixel = getBridgePixel();
            bridge.add(bridgePixel);
        }

        return bridge;
    }

    private String getBridgePixel() {
        int randomNumber = bridgeNumberGenerator.generate();
        if(randomNumber == 0) return BridgeGameInfo.LOWER_MOVE;
        return BridgeGameInfo.UPPER_MOVE;
    }


}
