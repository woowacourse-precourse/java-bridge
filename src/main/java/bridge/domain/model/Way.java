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
        if (where.equals(UP)) {
            if (isValid) {
                new Way("O", " ");
            }
            new Way("X", " ");
        }
        if (isValid) {
            new Way(" ", "O");
        }
        new Way(" ", "X");
    }

    public String getUp() {
        return up;
    }

    public String getDown() {
        return down;
    }

    public String getWay(int where) {
        validate(where);
        if (where == 0) {
            return up;
        }
        return down;
    }

    public void validate(int input) throws IllegalArgumentException {
        if (input != 0 && input != 1) {
            throw new IllegalArgumentException("[ERROR] Input is not 0 or 1");
        }
    }
}
