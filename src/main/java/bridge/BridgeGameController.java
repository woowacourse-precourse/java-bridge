package bridge;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private boolean isContinue;
    private int countOfAttempt;

    public BridgeGameController() {
        isContinue = true;
        countOfAttempt = 0;
    }

    private void makeBridge(int size) {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));

        this.bridgeGame = new BridgeGame(bridge);
    }
}
