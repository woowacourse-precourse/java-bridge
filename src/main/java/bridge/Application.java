package bridge;

import static bridge.BridgeGame.downstairsBridge;
import static bridge.BridgeGame.upstairsBridge;

import java.util.List;


public class Application {

    public static void main(String[] args) {
//        int i = 0;
//        do {
//            System.out.println(i++);
//        }
//        while (i < 3);
        // TODO: 프로그램 구현
        int GameCount = 1;
        OutputView outputView = new OutputView();
        outputView.gameStart();

        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        BridgeGame bridgeGame = new BridgeGame();

        int numberOfTriedAnswers;
        do {
            outputView.enterMoveDirection();
            String direction = inputView.readMoving();
            System.out.println(numberOfTriedAnswers = BridgeGame.getAnswerCount(direction));

            bridgeGame.move(direction, bridge, numberOfTriedAnswers);
            outputView.printMap(upstairsBridge, downstairsBridge);

            if (!bridgeGame.whetherGameSuccess(upstairsBridge,downstairsBridge)) {
                outputView.getRestartButton();
                String command = inputView.readGameCommand();
                if (bridgeGame.retry(command)) {
                    GameCount ++;
                    bridgeGame.returnToPreviousStatus(upstairsBridge, downstairsBridge);
                }
                if (!bridgeGame.retry(command))
                    return;
            }
        }
        while (!bridgeGame.whetherGameSuccess(upstairsBridge,downstairsBridge) || size > numberOfTriedAnswers);

        outputView.printResult(upstairsBridge, downstairsBridge);

    }
}
