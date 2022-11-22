package bridge;

public class Application {
    public static void main(String[] args) {
        OutputView.startGame();
        BridgeGame bridgeGame = new BridgeGame();
        BridgeGameController.startGame(bridgeGame);
        boolean flag = true;
        while (flag) {
            while(BridgeGameController.moveGame(bridgeGame)){}
            flag = BridgeGameController.endOrRetry(bridgeGame);
        }
    }
}


