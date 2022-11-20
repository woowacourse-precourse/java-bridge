package bridge.service;

import bridge.exception.BridgeIllegalArgumentException;
import bridge.setting.Setting;
import bridge.view.InputView;

public class BridgeLength {

    public int inputBridgeSize() {
        InputView inputView = new InputView();
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
            throw new BridgeIllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        if (bridgeSize > Setting.MAX_BRIDGE_SIZE) {
            throw new BridgeIllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
