package bridge.domain.model;

public class Way {

    private static final String UP = "u";
    private static final String DOWN = "d";

    String up;
    String down;

    public Way(String up, String down) {
        this.up = up;
        this.down = down;
    }

    public Way(String where, boolean isValid) {
        if (isValid) {
            if (where.equals(UP)) {
                new Way("O", " ");
            }
            new Way(" ", "O");
        }
        if (where.equals(UP)) {
            new Way("X", " ");
        }
        new Way(" ", "X");
    }
}
