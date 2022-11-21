package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final MoveResults moveResults = new MoveResults();

    public BridgeGame(BridgeMaker bridgeMaker, int size) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public void move(String controlKey) {
        moveResults.addResult(bridge.moveResult(moveResults().size(), controlKey));
    }

    public MoveResults moveResults() {
        return moveResults;
    }

    public void retry() {
        moveResults.removeFailure();
        moveResults.addTryNum();
    }

    public boolean isSuccess() {
        return moveResults.success();
    }

    public int bridgeSize() {
        return bridge.size();
    }

}
