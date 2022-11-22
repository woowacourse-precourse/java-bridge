package bridge;

import java.util.List;

public class Application {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static int bridgeSize;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            bridgeSize = inputView.readBridgeSize();
            System.out.println();
            BridgeGame bridgeGame = new BridgeGame(bridgeSize);
            start(bridgeGame);
            outputView.printResult(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void start(BridgeGame bridgeGame) throws IllegalArgumentException {
        while (true) {
            int status = run(bridgeGame);
            if (status == 0) {
                break;
            }
        }
    }

    private static int run(BridgeGame bridgeGame) throws IllegalArgumentException {
        String moving = inputView.readMoving();
        List<List<String>> userBridge = bridgeGame.move(moving);
        outputView.printMap(userBridge);
        if (isWrongUserBridge(userBridge)) {
            return checkRetry(bridgeGame);
        }
        return checkGameEnd(bridgeGame);
    }

    private static int checkGameEnd(BridgeGame bridgeGame) {
        if (bridgeGame.getUserInputBridge().get(0).size() != bridgeSize) {
            return -1;
        }
        return 0;
    }

    private static int checkRetry(BridgeGame bridgeGame) {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            return -1;
        }
        return 0;
    }

    private static boolean isWrongUserBridge(List<List<String>> userBridge) {
        if (userBridge.get(BridgeGame.UPWARD).contains("X") || userBridge.get(BridgeGame.DOWNWARD).contains("X")) {
            return true;
        }
        return false;
    }
}
