package bridge;

public class Controller {

	public void run() {
		InputView inputView = new InputView();

		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.play(inputView);
	}
}

