package bridge.Controller.Service;

import Utils.ValidateUtils;
import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.Bridge;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class StartGameService {

    public Bridge startGame() throws IllegalArgumentException {
        OutputView.printGameStart();
        String bridgeSize = InputView.readBridgeSize();
        ValidateUtils.isValidateLength(bridgeSize);
        int size = Integer.parseInt(bridgeSize);
        return makeNewBridge(size);

    }

    public Bridge makeNewBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new Bridge(bridge);
    }
}
