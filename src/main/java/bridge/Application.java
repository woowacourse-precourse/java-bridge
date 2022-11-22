package bridge;

import java.util.List;

import static bridge.OutputView.ox;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static final BridgeGame bridgeGame = new BridgeGame();

    private static List<String> bridge;
    private static String input;
    private static int tryCount = 1;
    private static int stepCount = 0;
    private static String retryCommand = "";

    public static String gameResult = "성공";

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        inputView.viewGameStartMessage();
        inputView.checkBridgeValidate();
        bridge = bridgeMaker.makeBridge(inputView.getSize());
        System.out.println(bridge);
        startMove(stepCount);
    }

    public static void startMove(int stepCount) {
        while (true) {
            input = inputView.readMoving();
            outputView.validateMap(input, bridge, stepCount);
            stepCount++;
            if (ox.equals(" X ")) {
                retryCommand = inputView.readGameCommand();
                restart(stepCount);
                break;
            }
            if (inputView.getSize() == stepCount) {
                outputView.printResult(stepCount, tryCount, gameResult);
                break;
            }
        }
    }

    public static void restart(int stepCount) {
        if (retryCommand.equals("R")) {
            outputView.clearBridge();
            bridgeGame.retry();
            tryCount++;
        }
        if (retryCommand.equals("Q")) {
            gameResult = "실패";
            outputView.printResult(stepCount, tryCount, gameResult);
        }
    }

}
