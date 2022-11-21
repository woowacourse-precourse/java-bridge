package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView;
        OutputView outputView;
        BridgeMaker bridgeMaker;
        BridgeGame bridgeGame;

        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker, inputView, outputView);

        bridgeGame.startGame();
    }
}
