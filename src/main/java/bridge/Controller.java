package bridge;

public class Controller {
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private static BridgeMaker bridgeMaker;
    private static InputException inputException;

    public Controller() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    public void startGame() {
        try {
            InputView inputView = new InputView();
            int bridgeSize = inputView.readBridgeSize();

            bridgeMaker.makeBridge(bridgeSize);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
