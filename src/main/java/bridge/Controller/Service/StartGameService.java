package bridge.Controller.Service;

import Utils.ValidateUtils;
import bridge.Domain.Bridge;
import bridge.Domain.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

public class StartGameService {

    public BridgeGame startGame() throws IllegalArgumentException {
        OutputView.printGameStart();
        String bridgeSize = InputView.readBridgeSize();
        ValidateUtils.isValidateLength(bridgeSize);
        int size = Integer.parseInt(bridgeSize);
        return new BridgeGame(new Bridge(size));
    }
}
