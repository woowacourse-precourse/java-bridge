package bridge.service;

import bridge.exception.BridgeIllegalArgumentException;
import bridge.service.BridgeNumberGenerator;
import bridge.setting.BridgeMakerEnum;
import bridge.setting.Setting;
import bridge.view.InputView;

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
