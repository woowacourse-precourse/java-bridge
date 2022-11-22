package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {
    private static BridgeController bridgeController = new BridgeController();
    private static BridgeGame bridgeGame = new BridgeGame();
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    public static void main(String[] args) {
        try {
            List<String> bridge = bridgeController.start();
            while (true) {
                if (bridgeController.repeat(bridge)) {
                    break;
                }
                String answer = inputView.readGameCommand();
                if (!bridgeGame.retry(answer)) {
                    outputView.printResult();
                    System.out.println("게임 성공 여부: 실패");
                    System.out.println("총 시도한 횟수: "+ bridgeController.count);
                    break;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
