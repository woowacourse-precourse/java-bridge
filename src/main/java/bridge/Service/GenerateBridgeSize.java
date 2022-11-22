package bridge.Service;

import bridge.InputView;
import bridge.OutputView;
import bridge.View.ValidateSet;

public class GenerateBridgeSize {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    ValidateSet validateSet = new ValidateSet();

    public int getBridgeSize() {
        outputView.guideStartGame();
        outputView.guideEnterBridgeSize();
        String size;
        while (!isValidate(size = inputView.readBridgeSize())) {
            outputView.guideEnterBridgeSize();
        }
        return Integer.parseInt(size);
    }

    private boolean isValidate(String size) {
        try {
            validateSet.Bridge(size);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
