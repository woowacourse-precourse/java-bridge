package bridge.game;

import bridge.view.UserMove;

public class GameCharacter {
    private final int MOVE = 1;
    private String nextMove;
    private int where = -1;

    public void setNextMove(UserMove move) {
        nextMove = move.getInput();
    }

    public void move() {
        where += MOVE;
    }

    public int showCurrentLocation() {
        return where;
    }

    public int showNextArea() {
        return where + MOVE;
    }

    public String showNextDestination() {
        return nextMove;
    }

    public void reset() {
        where = -1;
    }
}
