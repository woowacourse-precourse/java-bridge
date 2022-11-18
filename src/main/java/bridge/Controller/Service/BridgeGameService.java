package bridge.Controller.Service;

import Utils.ValidateUtils;
import bridge.Domain.Bridge;
import bridge.Domain.BridgeGame;
import bridge.Domain.GameResult;
import bridge.Domain.GameResultGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

public class BridgeGameService {
    private Bridge bridge;
    private GameResultGenerator gameResultGenerator;
    private BridgeGame bridgeGame;

    public BridgeGameService(Bridge bridge, GameResultGenerator gameResultGenerator) {
        this.bridge = bridge;
        this.gameResultGenerator = gameResultGenerator;
        this.bridgeGame = new BridgeGame(bridge);
    }

    public void onePhaseBridgeGame() throws IllegalArgumentException {
        String positionInput = InputView.readMoving();
        ValidateUtils.isValidatePosition(positionInput);
        GameResult gameResult = bridgeGame.move(positionInput);
        String bridgeStatus = getBridgeStatus(gameResult);
        OutputView.printMap(bridgeStatus);
    }

    public String getBridgeStatus(GameResult gameResult) {
        gameResultGenerator.setUpperBridgeResult(gameResult);
        gameResultGenerator.setLowerBridgeResult(gameResult);
        return gameResultGenerator.getGameResult();
    }
}
