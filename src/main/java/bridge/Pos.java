package bridge;

public enum Pos {
    D(0), U(1);

    private final int pos;

    Pos(int pos) {
        this.pos = pos;
    }

    public static String findPos(int num) {
        if (num == U.pos) {
            return U.name();
        }
        return D.name();
    }
}
