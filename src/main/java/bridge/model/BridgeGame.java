package bridge.model;

import bridge.utils.BridgeMaker;

public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final ResultManager resultFactory;
    private Bridges bridge;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        resultFactory = new ResultManager();
    }

    public void createBridge(int size) {
        bridge = new Bridges(bridgeMaker.makeBridge(size));
    }

    public ResultManager move(String moveSpace, int index) {
        boolean canMove = bridge.judgeMovement(moveSpace, index);
        resultFactory.setResult(moveSpace, canMove);
        return resultFactory;
    }

    public void retry() {
    }
}
