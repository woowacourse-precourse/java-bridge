package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.init();
        gameStart(bridgeGame);
        bridgeGame.printGameResult();
    }

    private static void gameStart(BridgeGame bridgeGame) {
        while (true){
            boolean move = bridgeGame.move();
            if(bridgeGame.isGameCompleted()){
                break;
            }
            if(!move && !bridgeGame.retry()){
                break;
            }
        }
    }
}
