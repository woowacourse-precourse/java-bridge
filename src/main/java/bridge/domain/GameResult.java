package bridge.domain;

import static bridge.view.OutputView.printGameStatistics;
import static bridge.view.OutputView.printResult;

public class GameResult {
    private final GameBoard topGameBoard;
    private final GameBoard bottomGameBoard;
    private final boolean isGameLose;
    private final int tryCount;


    public GameResult(GameBoard topGameBoard, GameBoard bottomGameBoard, boolean isGameLose, int tryCount) {
        this.topGameBoard = topGameBoard;
        this.bottomGameBoard = bottomGameBoard;
        this.isGameLose = isGameLose;
        this.tryCount = tryCount;
    }

    public void show() {
        printResult(topGameBoard, bottomGameBoard);
        printGameStatistics(isGameLose, tryCount);
    }
}
