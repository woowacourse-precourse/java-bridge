package bridge.Model;

public enum UpDownTable {
    UP(1, "U"),
    DOWN(0, "D");
    private int numberMove;
    private String stringMove;

    UpDownTable(int numberMove, String stringMove) {
        this.numberMove = numberMove;
        this.stringMove = stringMove;

    }

    public int getNumberMove() {
        return this.numberMove;
    }

    public String getStringMove() {
        return this.stringMove;
    }

    public static String get(int numberMove) {
        if (numberMove == UP.getNumberMove()){
            return UP.getStringMove();
        }
        return DOWN.getStringMove();
    }
}
