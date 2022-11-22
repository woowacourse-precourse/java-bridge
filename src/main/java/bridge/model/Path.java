package bridge.model;

public class Path {
    private final String direction;
    private final String pass;

    public Path(String direction, String pass) {
        this.direction = direction;
        this.pass = pass;
    }

    public String getDirection() {
        return direction;
    }

    public String getPass() {
        return pass;
    }
}
