package Model;

public enum Moving {

    Up("U"),
    Down("D");

    private final String moving;

    Moving(String moving) {
        this.moving = moving;
    }

    public String getMoving() {
        return moving;
    }
}
