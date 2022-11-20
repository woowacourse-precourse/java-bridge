package bridge;

import java.util.Arrays;

public class Application {

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
        BridgeMaker bridgeMaker = BridgeMaker.getInstance();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        int size;
        int count = 0;

        if (bridgeMaker.bridge == null) {
            size = inputView.readBridgeSize();
            bridgeMaker.makeBridge(size);
        }
        size = bridgeMaker.bridge.size();

        System.out.println(Arrays.toString(bridgeMaker.bridge.toArray(new String[0])));
        while (size-- > 0) {
            boolean result = bridgeGame.move(count);
            if (result) {
                outputView.printMap(count, result);
                System.out.println();
                count++;
            }
            if (!result) {
                outputView.printMap(count, result);
                System.out.println();
                String retry = bridgeGame.retry();
                return retry;
            }
        }
        return "성공";
    }
}
