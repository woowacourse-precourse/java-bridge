package bridge;

import java.util.Arrays;

public class Application {
    private static BridgeMaker bridgeMaker = BridgeMaker.getInstance();
    private static InputView inputView = new InputView();
    private static BridgeGame bridgeGame = new BridgeGame();
    private static OutputView outputView = new OutputView();
    private static int size;
    private static int count = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        int tryCount = 0;
        String flag = "retry";
        try {
            while (flag.equals("retry")) {
                flag = game();
                tryCount++;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        outputView.printResult(flag, tryCount);
    }

    static String game() {
        bridgeMaking(bridgeMaker, inputView);
        size = bridgeMaker.bridge.size();

        while (size-- > 0) {
            boolean result = bridgeGame.move(count, inputView.readMoving());
            count = answerCount(outputView, count, result);
            if (!result) {
                outputView.printMap(count, result);
                String retry = bridgeGame.retry(inputView.readGameCommand());
                return retry;
            }
        }
        return "성공";
    }

    private static int answerCount(OutputView outputView, int count, boolean result) {
        if (result) {
            outputView.printMap(count, result);
            System.out.println();
            count++;
        }
        return count;
    }

    private static void bridgeMaking(BridgeMaker bridgeMaker, InputView inputView) {
        int size;
        if (bridgeMaker.bridge == null) {
            size = inputView.readBridgeSize();
            bridgeMaker.makeBridge(size);
        }
    }
}
