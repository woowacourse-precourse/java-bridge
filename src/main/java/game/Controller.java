package game;

import inMemoryDB.GameData;
import view.InputView;
import view.OutputView;
import java.util.List;

public class Controller {

    public void run(int count, List<String> bridge) {
        GameData gameData;
        boolean isRestart;
        do {
            Game game = new Game();
            gameData = game.play(bridge);
            isRestart = setRestartStatus(gameData);
            count++;
        } while (isRestart);
        printEndMessage(gameData, count);
    }

    private boolean setRestartStatus(GameData gameData) {
        if (gameData.getPassDataSet().contains(GameResult.WRONG_FLOOR.getResultMessage())) {
            OutputView.printRestartStatusMessage();
            return BridgeGame.retry(InputView.readGameCommand());
        }
        return false;
    }

    private void printEndMessage(GameData gameData, int count) {
        OutputView.printFinalResultMessage();
        OutputView.printResult(gameData, count);
    }
}
