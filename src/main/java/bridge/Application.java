package bridge;

import bridge.Constants.StandardTools.GameStatus;
import bridge.Domain.BridgeGame;
import bridge.UI.InputView;
import bridge.UI.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGame game = new BridgeGame(inputView.readBridgeLength());
        while (game.isGameContinue()) {
            game.move(inputView.readMoving());
            if (game.getGameStatus() == GameStatus.FAILED) {
                game.retry(inputView.readGameCommand());
            }
            outputView.handleOutput(game.bridgeData.copyBridgeByUser(),
                    game.bridgeData.copyBridge(), game.getGameStatus());
        }
        outputView.printResult(game.getGameStatus(), game.bridgeData.getTotalAttempt());
    }

}
