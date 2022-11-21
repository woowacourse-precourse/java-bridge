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

    static void moveBundle(BridgeGame bridgeGame, List<String> bridge) {
        String movingChoice;

        OutputView.printMovingChoiceMessage();
        movingChoice = InputView.readMoving();
        bridgeGame.move(bridge, movingChoice);
        OutputView.printMap(bridgeGame.getUpMap(), bridgeGame.getDownMap());
    }

    static void retryBundle(BridgeGame bridgeGame) {
        String gameCommand;

        OutputView.printRetryMessage();
        gameCommand = InputView.readGameCommand();
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
        } else if (gameCommand.equals("Q")) {
            bridgeGame.quit();
        }
    }
}
