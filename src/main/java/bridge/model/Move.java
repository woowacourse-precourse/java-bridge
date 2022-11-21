package bridge.model;

public class Move {
    String direction;
    int moveIdx;
    int notMoveIdx;
    public Move(String direction, int moveIdx, int notMoveIdx){
        this.direction = direction;
        this.moveIdx = moveIdx;
        this.notMoveIdx = notMoveIdx;
    }
}
