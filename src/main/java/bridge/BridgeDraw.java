package bridge;

public enum BridgeDraw {
    start("["),
    success(" O "),
    fail(" X "),
    none(" "),
    line("|"),
    finish("]");

    private final String draw;

    private BridgeDraw(String printing) {
        this.draw = printing;
    }

    public String getDraw() {
        return this.draw;
    }
}
