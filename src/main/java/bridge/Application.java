package bridge;


import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());


        int bridgePositionIndex = 0;
        BridgeGame bridgeGame = new BridgeGame();
        while (bridgePositionIndex < bridge.size()) {
            String moving = inputView.readMoving();
            bridgeGame.move(new Bridge(bridge.get(bridgePositionIndex), moving));
            outputView.printMap(bridgeGame, bridgePositionIndex);
            if (!bridgeGame.getMyAnswerBridges().contains("X")){
                bridgePositionIndex++;
            }
            if (bridgeGame.getMyAnswerBridges().contains("X")) {
                String restartMessage = inputView.readGameCommand();
                if (restartMessage.equals("R")) {
                    outputView.retryBridgeMap();
                    bridgeGame.retry();
                    bridgePositionIndex = 0;
                }
                if (restartMessage.equals("Q")) {
                    outputView.printResult(restartMessage, bridgeGame.getAttemptCount());
                    bridgePositionIndex = bridge.size();
                }
            }
        }
        outputView.printResult(bridgeGame);
    }
}