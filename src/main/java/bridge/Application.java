package bridge;

import bridge.Constants.StandardTools.GameStatus;
import bridge.Domain.BridgeGame;
import bridge.UI.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame();
        OutputView outputView = new OutputView();
        while (game.getGameStatus() == GameStatus.PROGRESSING
                || game.getGameStatus() == GameStatus.RETRY) {
            game.move();
            outputView.printGameStatus(game.bridgeData.getBridgeDesignByUser(),
                    game.bridgeData.getBridge(), game.getGameStatus());
        }
        outputView.printResult(game.getGameStatus(), game.bridgeData.getTotalAttempt());
    }

}
