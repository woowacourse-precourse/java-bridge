package bridge;

import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        OutputView outputView = new OutputView();
        boolean isSuccess = true;

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println(bridge);

        for (int i = 0; i < bridgeSize; i++) {
            String moveAnswer = inputView.readMoving();
            if (!outputView.printMap(bridge, moveAnswer, i)) {
                String retryAnswer = inputView.readGameCommand();

                if (retryAnswer.equals("Q")) {
                    isSuccess = false;
                    break;
                }
            }
        }

        if (isSuccess) {
            System.out.println("게임 성공");
        }
    }
}
