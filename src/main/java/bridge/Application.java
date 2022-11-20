package bridge;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        outputView.printStartMessage();

        try {
            bridgeGame = new BridgeGame(inputView.readBridgeSize());
            System.out.println(bridgeGame.getRealBridge());

            while (true) {
                if (bridgeGame.hasSucceeded()) {
                    outputView.printResult(bridgeGame);
                    break;
                }
                boolean isCorrect = bridgeGame.move(inputView.readMoving());
                outputView.printMap(bridgeGame);
                if (isCorrect) {
                    continue;
                }
                if (inputView.readGameCommand().equals("R")) {
                    bridgeGame.retry();
                    continue;
                }
                outputView.printResult(bridgeGame);
                break;
            }
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return;
        }
    }

}
