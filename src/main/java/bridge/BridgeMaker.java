package bridge;

import bridge.BridgeNumberGenerator;
import bridge.setting.BridgeMakerEnum;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            bridge.add(String.valueOf(judgeRandomNumber(bridgeNumberGenerator.generate())));
        }

        return bridge;
    }

    private char judgeRandomNumber(int randomNumber) {
        return BridgeMakerEnum.valuesOfBridge(randomNumber);
    }

}
