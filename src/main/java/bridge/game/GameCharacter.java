package bridge.game;

public class GameCharacter {
    private String nextMove;
    private int where = 0;

    void getNextMove(String move) {
        nextMove = move;
    }

    void move() {
        where++;
    }

    int showCurrentLocation() {
        return where;
    }

    String showNextMove() {
        return nextMove;
    }
}
