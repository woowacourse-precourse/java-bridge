package bridge;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        outputView.printStartMessage();

        try {
            game();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return;
        }
    }

    private static void game() {
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
        System.out.println(bridgeGame.getRealBridge());

        while (true) {

            //게임 과정 처리해주는놈 -> true면 계속 가고, false면 break 하도록?

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
    }

}
