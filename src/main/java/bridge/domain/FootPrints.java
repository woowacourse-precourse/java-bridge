package bridge.domain;

public class FootPrints {

    private final FootPrint up;
    private final FootPrint down;

    public FootPrints() {
        up = new FootPrint();
        down = new FootPrint();
    }

    public void add(int status, String direction) {
        if (direction.equals("U")) {
            reflectStatus(status, up);
            down.add(" ");
            return;
        }
        reflectStatus(status, down);
        up.add(" ");
    }

    private void reflectStatus(int status, FootPrint footPrint) {
        if (status != User.DEAD) {
            footPrint.add("O");
            return;
        }
        footPrint.add("X");
    }

    public void reset() {
        up.clear();
        down.clear();
    }

    @Override
    public String toString() {
        return up.toString() + down.toString();
    }
}
