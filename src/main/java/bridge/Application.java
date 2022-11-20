package bridge;

public class Application {

	public static void main(String[] args) {
		try {
			BridgeGame bridgeGame = new BridgeGame();
			bridgeGame.play();
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
	}
}
