package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Map;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = makeBridgeException(bridgeMaker);
        BridgeGame bridgeGame = new BridgeGame(bridge, new Player(new Map()));
        OutputView.printStart();
        playGame(bridgeGame);
        OutputView.printResult(bridgeGame);
    }

    private static List<String> makeBridgeException(BridgeMaker bridgeMaker) {
        List<String> bridge;
        while (true) {
            try {
                bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bridge;
    }

    private static void playGame(BridgeGame bridgeGame) {
        while (true) {
            playGameOnce(bridgeGame);
            if (bridgeGame.hasSucceeded()) {
                break;
            }

            if (!retryException(bridgeGame)) {
                break;
            }
            bridgeGame.setPlayer(new Player(new Map()));
        }
    }

    private static boolean retryException(BridgeGame bridgeGame) {
        boolean willRetry;
        while (true) {
            try {
                willRetry = bridgeGame.retry(InputView.readGameCommand());
                return willRetry;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void playGameOnce(BridgeGame bridgeGame) {
        int totalRounds = bridgeGame.getTotalRounds();
        boolean isAnswer;
        for (int round = 0; round < totalRounds; round++) {
            isAnswer = playGameOnceException(bridgeGame, round);
            if (!isAnswer) {
                return;
            }
        }
    }

    private static boolean playGameOnceException(BridgeGame bridgeGame, int round) {
        while (true) {
            try {
                boolean isAnswer = bridgeGame.move(InputView.readMoving(), round);
                OutputView.printMap(bridgeGame.getMap());
                return isAnswer;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
