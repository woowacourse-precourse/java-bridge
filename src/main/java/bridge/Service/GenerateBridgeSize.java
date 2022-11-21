package bridge.Service;

import bridge.Entity.BridgeSize;
import bridge.View.InputValidate;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GenerateBridgeSize {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public int getBridgeSize() {
        outputView.guideEnterBridgeSize();
        String size;
        while (!isValidate(size = inputView.readBridgeSize())) {
            outputView.guideEnterBridgeSize();
            size = inputView.readBridgeSize();
        }
        BridgeSize bridgeSize = new BridgeSize(size);
        int convertSize = Integer.parseInt(bridgeSize.getSize());
        return convertSize;
    }

    public boolean isValidate(String size) {
        try {
            InputValidate inputValidate = new InputValidate();
            inputValidate.IsCorrectFormatBridgeSize(size);
            inputValidate.IsNoneInputBridgeSize(size);
            inputValidate.IsOverRangeBridgeSize(size);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
