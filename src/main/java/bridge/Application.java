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
            BridgeGame bridgeGame = new BridgeGame(bridgeSize);
            start(bridgeGame);
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
        if (!checkUserBridge(userBridge)) {
            if (inputView.readGameCommand().equals("R")) {
                bridgeGame.retry();
            }
            return -1;
        }
        return 0;
    }

    private static boolean checkUserBridge(List<List<String>> userBridge) {
        int size = userBridge.get(0).size();
        if (userBridge.get(BridgeGame.UPWARD).get(size - 1).equals("X") ||
                userBridge.get(BridgeGame.DOWNWARD).get(size - 1).equals("X")) {
            return false;
        }
        if (userBridge.size() != bridgeSize) {
            return false;
        }
        return true;
    }
}
