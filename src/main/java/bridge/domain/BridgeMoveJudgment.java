package bridge.domain;

public enum BridgeMoveJudgment {
    CORRECT("O"), WRONG("X"), EMPTY(" ");

    String shape;

    BridgeMoveJudgment(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
