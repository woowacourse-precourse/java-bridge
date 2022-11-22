package bridge.Service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.Bridge;
import bridge.Domain.UserBridges;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeService {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public Bridge makeBridge() {
        OutputView.printEnterBridgeSize();

        int bridgeSize = InputView.readBridgeSize();
        List<String> spaces = bridgeMaker.makeBridge(bridgeSize);

        return new Bridge(spaces, bridgeSize);
    }

    public UserBridges makeUserBridges() {
        return new UserBridges();
    }
}
