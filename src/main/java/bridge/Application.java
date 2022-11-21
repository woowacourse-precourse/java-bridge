package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printGreeting();
        BridgeGame bridgeGame = initialize(inputView, outputView);

        while (bridgeGame.getGameStatus().equals(GameStatus.ONGOING)) {
            outputView.printMoveInputMessage();
            String direction = inputView.readMoving();

            bridgeGame.move(direction);
            outputView.printMap(bridgeGame.getUserPath(), bridgeGame.getGameStatus());
        }
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
