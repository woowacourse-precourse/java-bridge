package bridge.service;

import bridge.exception.BridgeIllegalArgumentException;
import bridge.setting.Setting;
import bridge.view.InputView;

public class BridgeMove {

    public String inputMoveBridge() {
        InputView inputView = new InputView();
        String input = "";

        do {
            input = inputView.readMoving();
        } while (!isValidateInputMoveBridge(input));

        return input;
    }

    private boolean isValidateInputMoveBridge(String moveBridge) {
        try{
            checkIsMoveCode(moveBridge);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private void checkIsMoveCode(String input) {
        if (input.equals(Setting.PLAYER_MOVE_UP)) {
            return;
        }
        if (input.equals(Setting.PLAYER_MOVE_DOWN)) {
            return;
        }

        throw new BridgeIllegalArgumentException("올바른 코드를 입력해야 합니다. (위: U, 아래: D)");
    }
}
