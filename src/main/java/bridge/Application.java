package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        while(true){
            bridgeGame.move();
            if(bridgeGame.isGameDone()) break;
            if(bridgeGame.isGameQuit())break;
            bridgeGame.retry();
        }
        bridgeGame.stop();
    }
}
