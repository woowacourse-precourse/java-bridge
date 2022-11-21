package bridge;

import exception.UserInputException;
import game.BridgeGame;
import game.Controller;
import inMemoryDB.GameData;
import utils.GameResult;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        GameData gameData = new GameData();
        int count = 0;
        try {
            OutputView.printStartMessage();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
            boolean isRestart;
            do {
                isRestart = false;
                gameData = Controller.run(bridge);
                if (gameData.getPassDataSet().contains(GameResult.WRONG_FLOOR.getResultMessage())) {
                    OutputView.printRestartStatusMessage();
                    isRestart = BridgeGame.retry(InputView.readGameCommand());
                }
                count++;
            } while (isRestart);
        } catch (UserInputException e) {
            e.printStackTrace();
        }
        OutputView.printFinalResultMessage();
        OutputView.printResult(gameData, count);
    }
}
