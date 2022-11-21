package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static InputView inputView = new InputView();
    
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        

        System.out.println("다리 건너기 게임을 시작합니다");

        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        int gameCount = 0;

        while (true) {
            gameCount++;
            boolean matchingFlag = true;
            Bridge userBridge = new Bridge(new ArrayList<>(), new ArrayList<>());
            PlayerStatus playerStatus = null;

            for (String s : bridge) {

                playerStatus = isMatchingWithBridge(userBridge, s);

                bridgeGame.move(userBridge, playerStatus);

                outputView.printMap(userBridge);

                if (!playerStatus.isMatchingFlag()) {
                    break;
                }
            }

            if (!playerStatus.isMatchingFlag()) {
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

    private static PlayerStatus isMatchingWithBridge(Bridge bridge, String currentStep) {
        String nextStep = inputView.readMoving();

        if (currentStep.equals(nextStep)) {
            return new PlayerStatus(nextStep, true);
        }

        return new PlayerStatus(nextStep, false);
    }
}
