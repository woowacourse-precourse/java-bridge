package bridge;

public enum Move {

    UP(1, "U"),
    DOWN(0, "D");

    private int num;
    private String moveType;

    Move(int num, String moveType){
        this.num = num;
        this.moveType = moveType;
    }

    public String getMoveType() {
        return moveType;
    }
}
