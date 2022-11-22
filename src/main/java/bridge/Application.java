package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        gameStart(outputView, inputView, bridgeGame);
    }

    private static void gameStart(OutputView outputView, InputView inputView, BridgeGame bridgeGame) {
        outputView.printGameStart();
        Player player = new Player();
        player.makeRightBridge(inputView.readBridgeSize());
        bridgeGame.play(player);
        outputView.printResult(player);
    }
}
