package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        Integer bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        System.out.println(bridge);

        while (!bridgeGame.isEnd()) {
            String moving = inputView.readMoving();
            Boolean moved = bridgeGame.move(moving);
            outputView.printMap(bridgeGame, moved);
            if (moved) {
                continue;
            }

            String again = inputView.readGameCommand();
            if (again.equalsIgnoreCase(Constant.QUIT)) {
                break;
            }
            bridgeGame.retry();
        }
//        outputView.printResult();
        System.out.println("exit~");
    }
}
