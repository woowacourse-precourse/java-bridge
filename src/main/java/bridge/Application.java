package bridge;


public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();
        inputView.readBridgeSize(bridgeGame);
        while (bridgeGame.isInProgress) {
            while (bridgeGame.inputResult) {
                inputView.readMoving(bridgeGame);
            }
            inputView.readGameCommand(bridgeGame);
        }
    }
}
