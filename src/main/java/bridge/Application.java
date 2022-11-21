package bridge;


public class Application {

    static BridgeGame bridgeGame;

    public static void main(String[] args) {
        bridgeGame = new BridgeGame();
        bridgeGame.startGame();
    }
}
