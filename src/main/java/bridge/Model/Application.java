package bridge.Model;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        try {
            bridgeGame.gameStart();
        } catch (Exception e) {
            System.out.println("[ERROR]");
        }
    }
}
