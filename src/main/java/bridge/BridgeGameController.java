package bridge;

import java.util.List;

public class BridgeGameController {
    public static void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        List<String> bridge = createBridge(inputBridgeSize());

        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean isGameSuccess = playBridgeGame(bridgeGame);

        OutputView.printResult(bridgeGame,isGameSuccess);
    }

    private static boolean playBridgeGame(BridgeGame bridgeGame) {
        boolean isRetry = true;

        while(isRetry) {
            boolean isCrossBridgeSuccess = crossBridge(bridgeGame);
            if(isCrossBridgeSuccess) {
                return true;
            }
            isRetry = bridgeGame.retry(inputGameCommand());
        }
        return false;
    }

    private static boolean crossBridge(BridgeGame bridgeGame) {
        boolean isCrossBridge = true;
        int bridgeSize = bridgeGame.getBridge().size();

        while (isCrossBridge && bridgeGame.getCurrentBridgeIndex() < bridgeSize) {
            isCrossBridge = bridgeGame.move(inputMoveCommand());
            OutputView.printMap(bridgeGame, isCrossBridge);
        }
        return isCrossBridge;
    }

    private static int inputBridgeSize() {
        try {
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeSize();
        }
    }

    private static MoveCommand inputMoveCommand() {
        try {
            return InputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoveCommand();
        }
    }

    private static GameCommand inputGameCommand() {
        try {
            return InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputGameCommand();
        }
    }

    private static List<String> createBridge(int bridgeSize) {
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }
}
