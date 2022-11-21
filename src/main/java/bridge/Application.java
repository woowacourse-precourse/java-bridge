package bridge;

import java.util.List;

public class Application {
    final static BridgeGame bridgeGame = new BridgeGame();
    final static InputView inputView = new InputView();
    final static OutputView outputView = new OutputView();


    public static void main(String[] args) {
        bridgeGame.makeGame(inputView.readBridgeSize());
        int totalTry = 1;



        while (!bridgeGame.isDead()) {
            bridgeGame.move(inputView.readMoving());

            if (bridgeGame.isDead()) {
                bridgeGame.retry(inputView.readGameCommand());
                totalTry++;
            }
        }
        outputView.printResult(bridgeGame.isDead(), totalTry);


    }
}
