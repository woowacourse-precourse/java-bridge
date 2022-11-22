package bridge.domain;

public enum Moving {

    UP("U"),
    DOWN("D");

    private String direction;

    Moving(String direction) {
        this.direction = direction;
    }

    public String direction() {
        return this.direction;
    }

}
