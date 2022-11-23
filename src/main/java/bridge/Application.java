package bridge;

public class Application {

    public static void main(String[] args) {

        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        GameController gameController = new GameController(bridgeGame,outputView,inputView);

        try {
            gameController.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
