package bridge;

public class Application {
    private static final String RE_GAME = "R";

    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        play(bridgeGame);
    }

    private static void play(BridgeGame bridgeGame) {
        while (bridgeGame.inProgress()) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.bridge());
        }

        if (bridgeGame.isSuccess()) {
            printResult(bridgeGame);
            return;
        }
        decideReGame(bridgeGame);
    }

    private static void decideReGame(BridgeGame bridgeGame) {
        String command = inputView.readGameCommand();
        if (command.equals(RE_GAME)) {
            bridgeGame.retry();
            play(bridgeGame);
            return;
        }
        printResult(bridgeGame);
    }

    private static void printResult(BridgeGame bridgeGame) {
        outputView.printResult(bridgeGame.bridge(), bridgeGame.isSuccess(), bridgeGame.attemptCount());
    }
}
