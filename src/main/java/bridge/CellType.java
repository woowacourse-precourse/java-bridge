package bridge;

public enum CellType {
    DOWN("D"),
    UP("U");

    private String cell;

    CellType(String cell) {
        this.cell = cell;
    }

    public String getCell() {
        return cell;
    }
}
