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
        String size = inputView.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);
        int convertSize = Integer.parseInt(bridgeSize.getSize());
        return convertSize;
    }

}
