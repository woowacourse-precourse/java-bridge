package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printGreeting();
        BridgeGame bridgeGame = initialize(inputView, outputView);
    }

    private static void run(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        while (bridgeGame.getGameStatus().equals(GameStatus.ONGOING)) {
            move(inputView, outputView, bridgeGame);
        }
        if (bridgeGame.getGameStatus().equals(GameStatus.LOSE)) {
            outputView.printRetryInputMessage();
            bridgeGame.retry(inputView.readGameCommand());
        }
    }

    private static void move(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        do {
            try {
                outputView.printMoveInputMessage();
                bridgeGame.move(inputView.readMoving());
                outputView.printMap(bridgeGame.getUserPath(), bridgeGame.getGameStatus());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private static BridgeGame initialize(InputView inputView, OutputView outputView) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        do {
            outputView.printBridgeSizeInputMessage();
            try {
                return new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
