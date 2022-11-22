package bridge.core;

import bridge.type.GameStatus;

public class GameStatusOperator {

    private static final int START_POSITION = -1;
    private static final int NUMBER_OF_TRY = 0;

    private Integer currentPosition;
    private Integer numberOfTry;
    private GameStatus gameStatus;

    public GameStatusOperator(Integer currentPosition, Integer numberOfTry, GameStatus gameStatus) {
        this.currentPosition = currentPosition;
        this.numberOfTry = numberOfTry;
        this.gameStatus = gameStatus;
    }

    public static GameStatusOperator initGameStatusOperator() {
        return new GameStatusOperator(START_POSITION, NUMBER_OF_TRY, GameStatus.START);
    }

    public void incrementNumberOfTry() {
        numberOfTry++;
    }

    public void initPosition() { currentPosition = START_POSITION; }

    public void changePosition() { currentPosition++; }

    public void turnBackPosition() { currentPosition--; }

    public void toOngoing() { gameStatus = GameStatus.ONGOING; }

    public void toQuit() { gameStatus = GameStatus.QUIT; }

    public void toRestart() {
        gameStatus = GameStatus.RESTART;
    }

    //== Getter ==//
    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public Integer getNumberOfTry() {
        return numberOfTry;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

}
