package bridge.Service;

import bridge.View.InputView;
import bridge.View.OutputView;
import bridge.View.ValidateSet;

public class GenerateUserBridge {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    ValidateSet validateSet = new ValidateSet();

    public String getInput() {
        String input;
        outputView.guideEnterMove();
        while (!IsValidate(input = inputView.readMoving()))
            outputView.guideEnterMove();
        return input;
    }

    private boolean IsValidate(String input) {
        try {
            validateSet.User(input);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
