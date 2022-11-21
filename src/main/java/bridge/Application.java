package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        InputView inputView = new InputView();
//        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
//        outputView.printStart();
//        outputView.printAskBridgeLength();
//        inputView.readBridgeSize();
        bridgeGame.play();
    }
}
