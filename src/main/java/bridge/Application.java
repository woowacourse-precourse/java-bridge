package bridge;

public class Application {

	public static void main(String[] args) {
		try {
			int size = InputView.readBridgeSize();
			BridgeGame game = new BridgeGame();
			game.makeBridge(size);
			GameController.bridgeGameStart(game);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
}
