package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printGreeting();
        BridgeGame bridgeGame = initialize(inputView, outputView);
        do {
            run(inputView, outputView, bridgeGame);
        } while (retry(inputView, outputView, bridgeGame));
        outputView.printResult(bridgeGame);
    }

    private static void run(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        while (bridgeGame.getGameStatus().equals(GameStatus.ONGOING)) {
            move(inputView, outputView, bridgeGame);
        }
    }

    private static boolean retry(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        if (bridgeGame.getGameStatus().equals(GameStatus.LOSE)) {
            if (checkRetry(inputView, outputView)) {
                bridgeGame.retry();
                return true;
            }
        }
        return false;
    }

    private static boolean checkRetry(InputView inputView, OutputView outputView) {
        do {
            try {
                outputView.printRetryInputMessage();
                return inputView.readGameCommand().equals("R");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
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
