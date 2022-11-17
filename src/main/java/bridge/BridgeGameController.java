package bridge;

import java.util.List;

public class BridgeGameController {
    public static void run() {
        int bridgeSize = inputBridgeSize();
        List<String> bridge = createBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean successGame = isSuccessGame(bridgeGame, bridgeSize);
        OutputView.printResult(bridgeGame, successGame);
    }

    private static boolean isSuccessGame(BridgeGame bridgeGame, int bridgeSize) {
        boolean continueGame = true;
        while (continueGame) {
            State state = inputMoveCommand();
            continueGame = bridgeGame.move(state);
            OutputView.printMap(bridgeGame, continueGame);
            if (bridgeGame.getCurrentBridgeIndex() == bridgeSize - 1) {
                return true;
            }
        }
        return false;
    }

    private static int inputBridgeSize() {
        try {
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeSize();
        }
    }

    private static State inputMoveCommand() {
        try {
            return InputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoveCommand();
        }
    }

    private static String inputGameCommand() {
        try {
            return InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputGameCommand();
        }
    }

    private static List<String> createBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
