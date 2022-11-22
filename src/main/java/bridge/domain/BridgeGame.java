package bridge.domain;

public class BridgeGame {
    private final Bridge bridge;
    private BridgeGameResult result;

    public BridgeGame(BridgeLength bridgeLength, BridgeNumberGenerator generator) {
        this.bridge = new BridgeMaker(generator).makeBridge(bridgeLength);
        this.result = new BridgeGameResult();
        this.result.addTrial();
    }


    public boolean move(int round, BridgeMove move) {

        checkRoundIsConsecutive(round);
        checkPreviousRoundResultIsSuccess(round);
        checkBridgeMoveIsNotNull(move);

        BridgeGameTrialResult currentTrial = result.getCurrentTrialResult();
        boolean roundResult = canMove(round, move);
        currentTrial.addRoundResult(round, move, roundResult);
        return roundResult;
    }

    private void checkPreviousRoundResultIsSuccess(int round) {
        if (round >= 2 && !result.getCurrentTrialResult().isPreviousRoundSucceeded(round)) {
            throw new IllegalArgumentException("이전 라운드가 성공한 경우에만 다음 라운드를 진행할 수 있습니다");
        }
    }

    private void checkRoundIsConsecutive(int round) {
        if (round != result.getCurrentTrialResult().getTotalRound() + 1) {
            throw new IndexOutOfBoundsException("round는 이전 round + 1이어야 합니다.");
        }
    }

    private void checkBridgeMoveIsNotNull(BridgeMove move) {
        if (move == null) {
            throw new NullPointerException("move는 null이 될 수 없습니다.");
        }
    }

    private boolean canMove(int round, BridgeMove move) {
        return (bridge.getMove(round).equals(move));
    }

    public void retry() {
        result.addTrial();
    }

    public int getLength() {
        return bridge.getBridgeLength().getLength();
    }

    public BridgeGameResult getResult() {
        return result;
    }


}
