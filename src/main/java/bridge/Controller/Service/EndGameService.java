package bridge.Controller.Service;

import Utils.ValidateUtils;
import bridge.Domain.BridgeGame;
import bridge.EnumCollections.GameRestartType;
import bridge.View.InputView;
import bridge.View.OutputView;

public class EndGameService {
    private BridgeGame bridgeGame;

    public EndGameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public boolean isGameRestart() throws IllegalArgumentException {
        String input = InputView.readGameCommand();
        ValidateUtils.isValidateGameRestart(input);

        return input.equals(GameRestartType.RESTART.getRestartStatus());
    }

    public void endGame() {
        String bridgeStatus = bridgeGame.getBridgeResult();
        int gameCount = bridgeGame.getGameStartCount();
        boolean gameSuccess = bridgeGame.isMoveSuccess();
        OutputView.printResult(bridgeStatus, gameSuccess, gameCount);
    }

    public void restartGame() {
        bridgeGame.retry();
    }
}
