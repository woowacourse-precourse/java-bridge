package bridge;

import java.util.List;

public class BridgeGameRun {

    private BridgeGame bridgeGame;

    public void bridgeGameGenerate(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame = new BridgeGame(bridge);
    }

    public boolean gameRun(String direct) {
        boolean result = bridgeGame.move(direct);
        bridgeGame.bridgeMark(direct, result);
        return result;
    }

    public List<List<String>> bridgeMapGenerate() {
        return bridgeGame.getBridgeMap();
    }

    public boolean isEndBridge() {
        return bridgeGame.isEndBridge();
    }

    public void retry() {
        bridgeGame.retry();
    }

    public int getRetryCount() {
        return bridgeGame.getRetryCount();
    }

}
