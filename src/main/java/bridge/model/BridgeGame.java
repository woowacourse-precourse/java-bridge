package bridge.model;

import bridge.BridgeMaker;

public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private Bridge bridge;
    private BridgeResult bridgeResult;
    private ResultFlag resultFlag;
    private int tryCount = 1;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void create(int bridgeSize) {
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        bridgeResult = new BridgeResult(bridge);
    }

    public void move(String userMovingCommand) {
        resultFlag = bridgeResult.move(userMovingCommand);
    }

    public void retry() {
        bridgeResult.reset();
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public BridgeResult getMap() {
        return bridgeResult;
    }

    public ResultFlag getResultFlag() {
        return resultFlag;
    }

    public boolean completion() {
        return bridge.getSize() == bridgeResult.getCrossingCount();
    }
}
