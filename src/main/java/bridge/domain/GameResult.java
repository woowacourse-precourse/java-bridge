package bridge.domain;

import java.util.List;

import static bridge.view.OutputView.printGameStatistics;
import static bridge.view.OutputView.printResult;

public class GameResult {
    private final List<GameBoard> gameBoards;
    private final boolean isGameLose;
    private final int tryCount;


    public GameResult(List<GameBoard> gameBoards, boolean isGameLose, int tryCount) {
        this.gameBoards = gameBoards;
        this.isGameLose = isGameLose;
        this.tryCount = tryCount;
    }

    public void show() {
        GameBoard topGameBoard = gameBoards.get(0);
        GameBoard bottomGameBoard = gameBoards.get(1);

        printResult(topGameBoard, bottomGameBoard);
        printGameStatistics(isGameLose, tryCount);
    }
}
