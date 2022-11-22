package bridge.service.validator;

import bridge.exception.BridgeIllegalArgumentException;
import bridge.setting.Setting;
import bridge.view.InputView;

public class BridgeGameEnd {

    private final InputView inputView;

    public BridgeGameEnd(InputView inputView) {
        this.inputView = inputView;
    }

    public boolean isEnd() {
        if (inputGameEnd().equals(String.valueOf(Setting.GAME_EXIT)))
            return true;

        return false;
    }

    private String inputGameEnd() {
        String input = "";

        do {
            input = inputView.readGameCommand();
        } while (!isValidateInputGameEnd(input));

        return input;
    }

    private boolean isValidateInputGameEnd(String input) {
        try {
            checkIsEndCode(input);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private void checkIsEndCode(String input) {
        if (input.equals(String.valueOf(Setting.GAME_EXIT))) {
            return;
        }
        if (input.equals(String.valueOf(Setting.GAME_RE_START))) {
            return;
        }

        throw new BridgeIllegalArgumentException("올바른 코드를 입력해야 합니다. (종료: "+Setting.GAME_EXIT+", 재시도: "+Setting.GAME_RE_START+")");
    }
}
