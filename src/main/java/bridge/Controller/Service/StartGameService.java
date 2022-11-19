package bridge.Controller.Service;

import Utils.ValidateUtils;
import bridge.Domain.Bridge;
import bridge.Domain.BridgeGame;
import bridge.Domain.GameResultGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

public class StartGameService {
    GameResultGenerator gameResultGenerator;

    public StartGameService(GameResultGenerator gameResultGenerator) {
        this.gameResultGenerator = gameResultGenerator;
    }

    public BridgeGame startGame() throws IllegalArgumentException {
        OutputView.printGameStart();
        String bridgeSize = InputView.readBridgeSize();
        ValidateUtils.isValidateLength(bridgeSize);
        int size = Integer.parseInt(bridgeSize);
        return new BridgeGame(new Bridge(size), gameResultGenerator);
    }
}
