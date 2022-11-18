package bridge.Controller.Service;

import Utils.ValidateUtils;
import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.Bridge;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class StartGameService {
    private BridgeMaker bridgeMaker;
    private Bridge bridge;

    public StartGameService(Bridge bridge) {
        this.bridge = bridge;
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void startGame() throws IllegalArgumentException {
        OutputView.printGameStart();
        String bridgeSize = InputView.readBridgeSize();
        ValidateUtils.isValidateLength(bridgeSize);
        List<String> newBridge = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        this.bridge = new Bridge(newBridge);
    }
}
