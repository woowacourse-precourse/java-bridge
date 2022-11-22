package bridge;

import java.util.List;

public class Application {

    public static OutputView outputView;
    public static InputView inputView;
    public static BridgeGame bridgeGame;

    public static void main(String[] args) {
        initiateView();

        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        initiateBridgeGame(bridgeSize);

        bridgeGamePlay();
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.gameSucceeded(), bridgeGame.getCurLevel(), bridgeGame.getTryCount());
    }

    public static void initiateView() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public static void initiateBridgeGame(int bridgeSize) {
        bridgeGame = new BridgeGame(1, -1,
            new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize));
    }

    public static void bridgeGamePlay() {
        while (true) {
            boolean move = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridge(), bridgeGame.getCurLevel(), move);
            if (bridgeGame.checkGameEnded(move)) {
                if (bridgeGame.gameSucceeded()) break;
                String gameCommand = inputView.readGameCommand();
                if (gameCommand.equals("Q")) break;
                if (gameCommand.equals("R")) bridgeGame.retry();
            }
        }
    }

}
