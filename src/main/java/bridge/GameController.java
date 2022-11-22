package bridge;

public class GameController {


    private BridgeGame bridgeGame = new BridgeGame();
    private InputView inputView = new InputView();

    public void GameController() {

    }

    public void GameStart() {
        System.out.println(Command.START_MESSAGE + "\n" +Command.LENGTH_MESSAGE+ "\n");
        inputView.readBridgeSize();
    }
}
