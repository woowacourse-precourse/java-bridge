package bridge;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int tryCount = 0;
        String flag = "retry";
        while (flag.equals("retry")) {
            flag = game();
            tryCount++;
        }
        if (flag.equals("success")) {
            System.out.println("성공");
            System.out.println(tryCount);
        }
        if (flag.equals("fail")) {
            System.out.println("실패");
            System.out.println(tryCount);
        }
    }

    static String game() {
        BridgeMaker bridgeMaker = BridgeMaker.getInstance();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();

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
                count++;
            }
            if (!result) {
                String retry = bridgeGame.retry();
                return retry;
            }
        }
        return "success";
    }
}
