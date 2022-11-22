package bridge.domain;

public enum MoveSign {
    UP(1, "U"),
    DOWN(0, "D");

    private int moveNumber;
    private String moveContent;

    MoveSign(int number, String content) {
        this.moveNumber = number;
        this.moveContent = content;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public String getMoveContent() {
        return moveContent;
    }

}
