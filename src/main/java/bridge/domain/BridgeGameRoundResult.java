package bridge.domain;

public class BridgeGameRoundResult {
    private BridgeMove move;
    private boolean passed;

    public BridgeGameRoundResult(BridgeMove move, boolean passed) {
        if (move == null) {
            throw new NullPointerException("움직임은 null이 될 수 없습니다.");
        }
        this.move = move;
        this.passed = passed;
    }

    public BridgeMove getMove() {
        return move;
    }

    public boolean passed() {
        return passed;
    }
}
