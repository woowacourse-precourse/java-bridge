package bridge.Service;

import bridge.View.InputView;
import bridge.View.OutputView;
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
        int convertSize = Integer.parseInt(size);
        return convertSize;
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
