package bridge.model;

public enum Cell {

    BLANK(" "),
    CORRECT("O"),
    WRONG("X");

    private final String type;

    Cell(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
