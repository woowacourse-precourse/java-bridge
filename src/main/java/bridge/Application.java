package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.gameStart();
            bridgeGame.setBridgeSize();
            bridgeGame.playRound();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}