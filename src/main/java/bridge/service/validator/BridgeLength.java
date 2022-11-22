package bridge.service.validator;

import bridge.exception.BridgeIllegalArgumentException;
import bridge.setting.Setting;
import bridge.view.InputView;

public class BridgeLength {

    private final InputView inputView = new InputView();

    public BridgeLength() {
    }

    public int inputBridgeSize() {
        String input = "";

        do {
            input = inputView.readBridgeSize();
        } while (!isValidateInputBridgeSize(input));

        return Integer.parseInt(input);
    }

    private boolean isValidateInputBridgeSize(String bridgeSize) {
        try{
            checkIsNumber(bridgeSize);
            checkIsRightRange(Integer.parseInt(bridgeSize));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private void checkIsNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            throw new BridgeIllegalArgumentException("다리 길이는 숫자여야 합니다.");
        }
    }

    private void checkIsRightRange(int bridgeSize) {
        if (bridgeSize < Setting.MIN_BRIDGE_SIZE) {
            throw new BridgeIllegalArgumentException("다리 길이는 "+Setting.MIN_BRIDGE_SIZE+"부터 "+Setting.MAX_BRIDGE_SIZE+" 사이의 숫자여야 합니다.");
        }
        if (bridgeSize > Setting.MAX_BRIDGE_SIZE) {
            throw new BridgeIllegalArgumentException("다리 길이는 "+Setting.MIN_BRIDGE_SIZE+"부터 "+Setting.MAX_BRIDGE_SIZE+" 사이의 숫자여야 합니다.");
        }
    }
}
