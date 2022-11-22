package bridge;

public class Application {
    static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        bridgeGame.gameStart();
        while (true){
            boolean isFinish = bridgeGame.gamePlay();
            if (isFinish){
                break;
            }
        }
    }

}
