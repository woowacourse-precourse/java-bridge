package bridge.domain;

public enum BridgeMoveJudgment {
    CORRECT("O"), WRONG("X"), EMPTY(" ");

    private final String shape;

    BridgeMoveJudgment(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
