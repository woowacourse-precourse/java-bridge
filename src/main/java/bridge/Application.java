package bridge;

import java.util.List;

public class Application {
    private static int currentPosition = 0;
    public static void main(String[] args) {
        try {
            OutputView outputView = new OutputView();
            InputView inputView = new InputView();
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

            outputView.printGameStartMessage();
            int bridgeSize = inputView.readBridgeSize();
            System.out.println("bridgeSize = " + bridgeSize);

            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            System.out.println("bridge = " + bridge);

            BridgeGame bridgeGame = new BridgeGame(bridgeSize, bridge);
            List<List<String>> bridgeMap = bridgeGame.getBridgeMap();
            System.out.println("bridgeMap = " + bridgeMap);

            while (true) {
                if (play(bridgeSize, bridgeGame, inputView, outputView)) {
                    break;
                }
                if (inputView.readGameCommand().equals("Q")) {
                    break;
                }
                bridgeGame.retry();
            }
            outputView.printResult(currentPosition, bridgeGame);

        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public static boolean play(int bridgeSize, BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        currentPosition = 0;
        for (; currentPosition < bridgeSize; currentPosition++) {
            String cmd = inputView.readMoving();
            System.out.println("cmd = " + cmd);

            boolean isSuccess = bridgeGame.move(cmd, currentPosition);
            System.out.println("isSuccess = " + isSuccess);

            outputView.printMap(currentPosition+1, bridgeGame.getBridgeMap());
            if(!isSuccess) {
                return false;
            }
        }
        return true;
    }
}
