package bridge;

public enum MoveDirection {
    U(1 ,"U") , D(0,"D");

    public int numMoveDirection;
    public String strMoveDirection;

    MoveDirection(int numMoveDirection , String strMoveDirection) {
        this.numMoveDirection = numMoveDirection;
        this.strMoveDirection = strMoveDirection;
    }
}
