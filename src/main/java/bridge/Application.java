package bridge;

import static bridge.BridgeGame.downstairsBridge;
import static bridge.BridgeGame.upstairsBridge;

import java.util.List;


public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        int gameCount = 1;
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
                    gameCount ++;
                    System.out.println(upstairsBridge);
                    System.out.println(downstairsBridge);
                    bridgeGame.returnToPreviousStatus(upstairsBridge, downstairsBridge);
                    System.out.println(upstairsBridge);
                    System.out.println(downstairsBridge);
                }
                if (!bridgeGame.retry(command)) {
                    System.out.println(bridgeGame.retry(command));

                    outputView.printResult(upstairsBridge, downstairsBridge, gameCount);
                    return;
                }
            }
        }
        while (!bridgeGame.whetherGameSuccess(upstairsBridge,downstairsBridge) || size > upstairsBridge.size());

        outputView.printResult(upstairsBridge, downstairsBridge, gameCount);
    }
}
