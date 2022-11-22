package bridge;

public class GameClear {

    private final boolean gameClear;

    public GameClear(boolean gameClear) {
        this.gameClear = gameClear;
    }

    public boolean get() {
        return gameClear;
    }

    public void printGameClear(int countOfTry) {
        if (gameClear) {
            OutputView.printGameClear("성공", countOfTry);
            return;
        }
        OutputView.printGameClear("실패", countOfTry);
    }
}
