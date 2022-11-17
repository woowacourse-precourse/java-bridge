package bridge.game;

public class GameCharacter {
    private final int MOVE = 1;
    private String nextMove;
    private int where = -1;

    void setNextMove(String move) {
        nextMove = move;
    }

    void move() {
        where += MOVE;
    }

    int showCurrentLocation() {
        return where;
    }

    int showNextArea(){
        return where + MOVE;
    }

    String showNextDestination() {
        return nextMove;
    }
}
