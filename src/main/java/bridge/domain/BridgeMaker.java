package bridge.domain;

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

    public char judgeRandomNumber(int randomNumber) {
        return BridgeMakerEnum.valuesOfBridge(randomNumber);
    }

    public int inputBridgeSize() {
        InputView inputView = new InputView();
        String input = new String();

        while (!isValidateInputBridgeSize(input)) {
            input = inputView.readBridgeSize();
        }

        return Integer.parseInt(input);
    }

    public boolean isValidateInputBridgeSize(String bridgeSize) {
        try{
            checkIsNumber(bridgeSize);
            checkIsRightRange(Integer.parseInt(bridgeSize));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public void checkIsNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            throw new BridgeIllegalArgumentException("다리 길이는 숫자여야 합니다.");
        }
    }

    public void checkIsRightRange(int bridgeSize) {
        if (bridgeSize < Setting.MIN_BRIDGE_SIZE) {
            throw new BridgeIllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        if (bridgeSize > Setting.MAX_BRIDGE_SIZE) {
            throw new BridgeIllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
