package bridge;

public class Application {
    static InputView inputView = new InputView(new Validator());
    static OutputView outputView = new OutputView();
    static BridgeGame bridgeGame = new BridgeGame(inputView, outputView);
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int size = inputView.readBridgeSize();
            bridgeGame.setBridge(bridgeMaker.makeBridge(size));
            bridgeGame.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}