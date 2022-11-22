package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();

        bridgeGame.setCorrectBridge(bridgeMaker.makeBridge(size));

        int bridgeNumber = 0;
        while (true) {
            bridgeGame.move(inputView.readMoving(), bridgeNumber);
            bridgeNumber++;
        }
    }
}
