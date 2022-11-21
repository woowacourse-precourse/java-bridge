package bridge;

import java.util.List;

public class Application {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int bridgeSize = inputView.readBridgeSize();
            BridgeGame bridgeGame = new BridgeGame(bridgeSize);
            run(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void run(BridgeGame bridgeGame) {
        String moving = inputView.readMoving();
        List<List<String>> userBridge = bridgeGame.move(moving);
    }
}
