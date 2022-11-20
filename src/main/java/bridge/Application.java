package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        OutputView outputView = new OutputView();

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println(bridge);

        for (int i = 0; i < bridgeSize; i++) {
            String moveAnswer = inputView.readMoving();
            boolean isWinning = outputView.printMap(bridge, moveAnswer, i);

            if (!isWinning) {
                String retryAnswer = inputView.readGameCommand();

                if (retryAnswer.equals("Q")) {
                    break;
                }
            }
        }

        System.out.println("게임 성공");
    }
}
