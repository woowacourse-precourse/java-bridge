package bridge.Service;

import bridge.Entity.BridgeSize;
import bridge.View.InputValidate;
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
        BridgeSize bridgeSize = new BridgeSize(size);
        int convertSize = Integer.parseInt(bridgeSize.getSize());
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
