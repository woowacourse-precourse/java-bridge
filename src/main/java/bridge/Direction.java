package bridge;

public enum Direction {
    DOWN( 0, "D"), UP( 1,"U");

    private final int id;
    private final String symbol;

    Direction(int id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public int getNumber() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }
}
