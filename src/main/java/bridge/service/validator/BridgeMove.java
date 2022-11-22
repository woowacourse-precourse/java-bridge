package bridge.service.validator;

import bridge.exception.BridgeIllegalArgumentException;
import bridge.setting.Setting;
import bridge.view.InputView;

public class BridgeMove {

    private final InputView inputView;

    public BridgeMove(InputView inputView) {
        this.inputView = inputView;
    }

    public String inputMoveBridge() {
        String input = "";

        do {
            input = inputView.readMoving();
        } while (!isValidateInputMoveBridge(input));

        return input;
    }

    private boolean isValidateInputMoveBridge(String input) {
        try{
            checkIsMoveCode(input);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private void checkIsMoveCode(String input) {
        if (input.equals(String.valueOf(Setting.PLAYER_MOVE_UP))) {
            return;
        }
        if (input.equals(String.valueOf(Setting.PLAYER_MOVE_DOWN))) {
            return;
        }

        throw new BridgeIllegalArgumentException("올바른 코드를 입력해야 합니다. (위: "+Setting.PLAYER_MOVE_UP+", 아래: "+Setting.PLAYER_MOVE_DOWN+")");
    }
}
