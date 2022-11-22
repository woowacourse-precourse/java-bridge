package bridge;

public enum CommandType {
    DOWN("D"),
    UP("U"),
    RETRY("R"),
    QUIT("Q");

    private final String cell;

    CommandType(String cell) {
        this.cell = cell;
    }

    public String getCell() {
        return cell;
    }
}
