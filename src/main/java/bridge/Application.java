package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        System.out.println("다리 건너기 게임을 시작합니다");

        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        int gameCount = 0;

        while (true) {
            gameCount++;
            boolean matchingFlag = true;
            Bridge userBridge = new Bridge(new ArrayList<>(), new ArrayList<>());

            for (String s : bridge) {

                String nextStep = inputView.readMoving();

                if (!nextStep.equals(s)) {
                    matchingFlag = false;
                }

                bridgeGame.move(userBridge, nextStep, matchingFlag);

                outputView.printMap(userBridge);

                if (!matchingFlag) {
                    break;
                }

            }

            if (matchingFlag) {
                outputView.printResult(userBridge, gameCount, matchingFlag);
                break;
            }

            String retryCommand = inputView.readGameCommand();

            if (bridgeGame.retry(retryCommand)) {
                outputView.printResult(userBridge, gameCount, matchingFlag);
                break;
            }
        }
    }
}
