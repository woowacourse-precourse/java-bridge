package bridge;

import bridge.type.GameStatus;

public class GameStatusOperator {

    private Integer currentPosition;
    private Integer numberOfTry;
    private GameStatus gameStatus;

    public GameStatusOperator(Integer currentPosition, Integer numberOfTry, GameStatus gameStatus) {
        this.currentPosition = currentPosition;
        this.numberOfTry = numberOfTry;
        this.gameStatus = gameStatus;
    }

    public void tryOnce() {
        numberOfTry++;
    }

    public void changePosition() {
        currentPosition++;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public Integer getNumberOfTry() {
        return numberOfTry;
    }

}
