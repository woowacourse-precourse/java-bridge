package bridge.domain.enums;

public enum BridgePanel {
    UP_PANEL(1, "U"),
    DOWN_PANEL(0, "D");

    private final int number;
    private final String position;

    BridgePanel(int number, String position) {
        this.number = number;
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }
}