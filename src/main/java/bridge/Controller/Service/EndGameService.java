package bridge.Controller.Service;

import Utils.ValidateUtils;
import bridge.Domain.BridgeGame;
import bridge.Domain.GameResult;
import bridge.Domain.GameResultGenerator;
import bridge.EnumCollections.GameRestartType;
import bridge.View.InputView;
import bridge.View.OutputView;

public class EndGameService {
    private BridgeGame bridgeGame;
    private GameResultGenerator gameResultGenerator;

    public EndGameService(BridgeGame bridgeGame, GameResultGenerator gameResultGenerator) {
        this.bridgeGame = bridgeGame;
        this.gameResultGenerator = gameResultGenerator;
    }

    public boolean isGameRestart() throws IllegalArgumentException {
        String input = InputView.readGameCommand();
        ValidateUtils.isValidateGameRestart(input);

        return input.equals(GameRestartType.RESTART.getRestartStatus());
    }

    public void endGame(GameResult gameResult) {
        String bridgeStatus = gameResultGenerator.getGameResult();
        int gameGount = bridgeGame.getGameStartCount();
        boolean gameSuccess = gameResult.isGameSuccess();
        OutputView.printResult(bridgeStatus, gameSuccess, gameGount);
    }
}
