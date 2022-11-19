package bridge;

public class Application {

    private static final String ERROR = "[ERROR]";
    private static BridgeController bridgeController;

    public static void main(String[] args) {
        dependencyInjection();
        try {
            bridgeController.run();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(ERROR + " " + e.getMessage());
        }
    }

    private static void dependencyInjection() {
        BridgeStatusSaver bridgeStatusSaver = new BridgeStatusSaver();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, bridgeStatusSaver);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        bridgeController = new BridgeController(bridgeGame, inputView, outputView);
    }
}
