package bridge;

public class Application {
	private static final int GAME_COUNT_START = 1;

	public static void main(String[] args) {
		BridgeGameController bridgeGameController = new BridgeGameController();
		bridgeGameController.gameStart(GAME_COUNT_START);
	}
}
