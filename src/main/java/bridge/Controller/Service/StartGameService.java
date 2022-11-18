package bridge.Controller.Service;

import Utils.ValidateUtils;
import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.Bridge;
import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class StartGameService {

    public BridgeGame startGame() throws IllegalArgumentException {
        OutputView.printGameStart();
        String bridgeSize = InputView.readBridgeSize();
        ValidateUtils.isValidateLength(bridgeSize);
        return new BridgeGame(new Bridge(Integer.parseInt(bridgeSize)));
    }
}
