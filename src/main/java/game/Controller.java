package game;

import inMemoryDB.GameData;
import utils.InputCheck;
import view.OutputView;
import java.util.List;

public class Controller {

    public void run(int count, List<String> bridge) {
        GameData gameData;
        boolean isRestart;
        do {
            Game game = new Game();
            gameData = game.play(bridge);
            isRestart = isRestart(gameData);
            count++;
        } while (isRestart);
        printEndMessage(gameData, count);
    }

    private boolean isRestart(GameData gameData) {
        if (gameData.getPassDataSet().contains(GameResult.WRONG_FLOOR.getResultMessage())) {
            OutputView.printRestartStatusMessage();
            return BridgeGame.retry(InputCheck.restartStatusValue());
        }
        return false;
    }

    private void printEndMessage(GameData gameData, int count) {
        OutputView.printFinalResultMessage();
        OutputView.printResult(gameData, count);
    }
}
