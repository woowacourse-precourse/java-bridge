package bridge.status;

public enum PositionStatus {

    UP("U"),
    DOWN("D");

    private String text;

    PositionStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
