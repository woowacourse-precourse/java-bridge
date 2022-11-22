package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        try {
            List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
            BridgeGame bridgeGame = new BridgeGame(bridge);
            run(inputView, outputView, bridgeGame);
            outputView.printResult(bridgeGame.getBridgeMap(), bridgeGame.getGameStatus(), bridgeGame.getTryCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run(final InputView inputView, final OutputView outputView, final BridgeGame bridgeGame) {
        do {
            outputView.printMap(bridgeGame.move(inputView.readMoving()));
            if (bridgeGame.getGameStatus().equals(GameStatus.LOSE)) {
                bridgeGame.retry(inputView.readGameCommand());
            }
        } while (bridgeGame.getGameStatus().equals(GameStatus.CONTINUE));
    }
}
