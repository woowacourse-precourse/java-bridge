package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int successCount = 0;
        int trialCount = 1;
        String check = "";

        outputView.startMessage();
        inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(inputView.bridgeSize_in);

        while (successCount < inputView.bridgeSize_in) {
            inputView.readMoving();
            bridgeGame.move(inputView.upAndDown_in, bridge, successCount);
            outputView.printMap();
            check = bridgeGame.validCheck(successCount + 1, inputView.bridgeSize_in);
            if (check.equals("실패")) {
                inputView.readGameCommand();
                successCount = bridgeGame.retry(inputView.retryAndQuit_in);
                trialCount = bridgeGame.trialAddValidCheck(inputView.retryAndQuit_in, trialCount);
            }
            successCount++;
        }
        outputView.printResult(check, trialCount);
    }
}
