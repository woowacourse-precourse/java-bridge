package bridge;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge;

        OutputView.printStartMessage();
        bridge = bridgeBundle();
        moveOrRetry(bridgeGame, bridge);
        OutputView.printResult(bridgeGame);
    }

    static List<String> bridgeBundle() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge;
        int bridgeLen;

        OutputView.printBridgeSizeMessage();
        bridgeLen = InputView.readBridgeSize();
        System.out.print("\n");
        bridge = bridgeMaker.makeBridge(bridgeLen);

        return bridge;
    }

    static void moveOrRetry(BridgeGame bridgeGame, List<String> bridge) {
        while (bridgeGame.getPlayerLocationIndex() < bridge.size() - 1) {
            moveBundle(bridgeGame, bridge);
            if (bridgeGame.getAskRetryMarker()) {
                retryBundle(bridgeGame);
            }
        }
    }
}
