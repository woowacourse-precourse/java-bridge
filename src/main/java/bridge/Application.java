package bridge;


public class Application {

    public static void main(String[] args) {

        GameController gameController = new GameController();
        gameController.makeBridgeGame();
        gameController.playBridgeGame();
        gameController.sumUpBridgeGame();
    }
}
