package bridge;

public class Controller {

	private static final String EXIT_MESSAGE = "게임을 종료합니다.";
	private static final String ENTER = "\n";

	public void run() {
		try {
			InputView inputView = new InputView();
			BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
			BridgeGame bridgeGame = new BridgeGame();

			bridgeGame.play(inputView, bridgeMaker);
		} catch (IllegalArgumentException ignored) {
		} finally {
			OutputView.printGameInfo(ENTER + EXIT_MESSAGE);
		}
	}
}
